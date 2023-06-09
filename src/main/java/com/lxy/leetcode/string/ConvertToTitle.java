package com.lxy.leetcode.string;

/**
 * <a href="https://leetcode.cn/problems/excel-sheet-column-title/">Excel表列名称</a>
 */
public class ConvertToTitle {

    public static String convertToTitle(int columnNumber) {
        final int MAX_STRING_SIZE = 7; // "FXSHRXW"(2147483647)
        final int RADIX = 26;

        char[] buffer = new char[MAX_STRING_SIZE];
        int index = MAX_STRING_SIZE - 1;
        while (columnNumber > 0) {
            int div = columnNumber / RADIX;
            int rem = columnNumber - div * RADIX;
            char ch;
            if (rem == 0) {
                ch = 'Z';
                div--;
            } else {
                ch = (char) (rem + ('A' - 1));
            }
            buffer[index--] = ch;
            columnNumber = div;
        }
        return new String(buffer, index + 1, (MAX_STRING_SIZE - 1) - index);
    }

    public static String convertToTitleOptimized(int columnNumber) {
        final int MAX_STRING_SIZE = 7; // "FXSHRXW"(2147483647)
        final int RADIX = 26;

        char[] buffer = new char[MAX_STRING_SIZE];
        int index = MAX_STRING_SIZE - 1;
        while (columnNumber > 0) {
            // 减一取模
            columnNumber--;
            int div = columnNumber / RADIX;
            buffer[index--] = (char) (columnNumber - div * RADIX + 'A');
            columnNumber = div;
        }
        return new String(buffer, index + 1, (MAX_STRING_SIZE - 1) - index);
    }
}
