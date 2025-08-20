package com.lxy.leetcode.string;

import com.lxy.leetcode.util.MathUtil;

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
        var list = new ArrayList<String>(words.length);
        for (var word : words) {
            var rowPattern = 0;
            for (var i = 0; i < word.length(); i++) {
                rowPattern |= ROW_PATTERNS[(word.charAt(i) | 32) /* try convert to lower case */ - 'a'];
            }
            // Row pattern is a power of two
            if (MathUtil.isPowerOfTwo(rowPattern)) {
                list.add(word);
            }
        }
        return list.toArray(EMPTY);
    }
}
