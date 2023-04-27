package com.lxy.leetcode.misc;

/**
 * <a href="https://leetcode.cn/problems/roman-to-integer/">罗马数字转整数</a>
 */
public class RomanToInt {
    private static final short[] ROMAN = new short[]{
            // C D E F G H I J K L M
            100, 500, 0, 0, 0, 0, 1, 0, 0, 50, 1000,
            // N O P Q R S T U V W X
            0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 10
    };

    public static int romanToInt(String s) {
        int sum = 0;
        int prev = 0 /* sentinel */, next;
        for (int i = s.length() - 1; i >= 0; i--) {
            next = ROMAN[s.charAt(i) - 'C'];
            if (next < prev) {
                sum -= next;
            } else {
                sum += next;
            }
            prev = next;
        }
        return sum;
    }
}
