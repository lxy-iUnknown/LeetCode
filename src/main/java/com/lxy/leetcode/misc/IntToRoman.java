package com.lxy.leetcode.misc;

/**
 * <a href="https://leetcode.cn/problems/integer-to-roman/">整数转罗马数字</a>
 */
public class IntToRoman {
    private static final int MAX_ROMAN_SIZE = 3 + 4 + 4 + 4; // MMMDCCCLXXXVIII(3888)

    private static final String[] ROMAN_THOUSANDS = new String[]{
            "", "M", "MM", "MMM"
    };

    private static final String[] ROMAN_HUNDREDS = new String[]{
            "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"
    };

    private static final String[] ROMAN_TENS = new String[]{
            "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"
    };

    private static final String[] ROMAN_ONES = new String[]{
            "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"
    };

    public static String intToRoman(int number) {
        StringBuilder sb = new StringBuilder(MAX_ROMAN_SIZE);
        int temp;
        temp = number / 1000;
        sb.append(ROMAN_THOUSANDS[temp]);
        number = number - temp * 1000;
        temp = number / 100;
        sb.append(ROMAN_HUNDREDS[temp]);
        number = number - temp * 100;
        temp = number / 10;
        sb.append(ROMAN_TENS[temp]);
        sb.append(ROMAN_ONES[number - temp * 10]);
        return sb.toString();
    }
}