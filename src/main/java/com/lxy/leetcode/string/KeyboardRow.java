package com.lxy.leetcode.string;

import java.util.ArrayList;

/**
 * <a href="https://leetcode.cn/problems/keyboard-row/">键盘行</a>
 */
public class KeyboardRow {

    @SuppressWarnings("PointlessBitwiseExpression")
    private static final int FIRST_ROW = 1 << 0;
    private static final int SECOND_ROW = 1 << 1;
    private static final int THIRD_ROW = 1 << 2;

    private static final byte[] ROW_PATTERNS = new byte[]{
            SECOND_ROW, THIRD_ROW, THIRD_ROW, SECOND_ROW, FIRST_ROW, SECOND_ROW,
            SECOND_ROW, SECOND_ROW, FIRST_ROW, SECOND_ROW, SECOND_ROW, SECOND_ROW,
            THIRD_ROW, THIRD_ROW, FIRST_ROW, FIRST_ROW, FIRST_ROW, FIRST_ROW,
            SECOND_ROW, FIRST_ROW, FIRST_ROW, THIRD_ROW, FIRST_ROW, THIRD_ROW,
            FIRST_ROW, THIRD_ROW
    };

    private static final String[] EMPTY = new String[0];

    public static String[] findWords(String[] words) {
        ArrayList<String> list = new ArrayList<>(words.length);
        for (String word : words) {
            int rowPattern = 0;
            for (int i = 0; i < word.length(); i++) {
                rowPattern |= ROW_PATTERNS[(word.charAt(i) | 32) /* try convert to lower case */ - 'a'];
            }
            // Row pattern is a power of two
            if ((rowPattern & (rowPattern - 1)) == 0) {
                list.add(word);
            }
        }
        return list.toArray(EMPTY);
    }
}
