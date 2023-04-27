package com.lxy.leetcode.string;

/**
 * <a href="https://leetcode.cn/problems/convert-a-number-to-hexadecimal/">数字转换为十六进制数</a>
 */
public class ToHex {
    private static final char[] HEX_CHARS = new char[]{
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
    };

    public static String toHex(int number) {
        final int MAX_STRING_SIZE = 8;

        char[] buffer = new char[MAX_STRING_SIZE];
        int index = MAX_STRING_SIZE - 1;
        // Special case
        if (number == 0) {
            buffer[index--] = '0';
        }
        // Generate digits backward
        while (number != 0) {
            buffer[index--] = HEX_CHARS[number & 0xf];
            // Unsigned right shift
            number >>>= 4;
        }
        return new String(buffer, index + 1, MAX_STRING_SIZE - 1 - index);
    }
}