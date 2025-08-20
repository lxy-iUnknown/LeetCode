package com.lxy.leetcode.array1d;

/**
 * <a href="https://leetcode.cn/problems/plus-one/">加一</a>
 */
public class PlusOne {

    public static int[] plusOne(int[] digits) {
        var length = digits.length;
        var i = length - 1;
        var digit = digits[i] + 1; // plus one
        if (digit < 10) {
            digits[i] = digit;
        } else {
            digits[i--] = 0;
            while (i >= 0) {
                digit = digits[i] + 1; // plus carry
                if (digit < 10) {
                    digits[i] = digit;
                    return digits;
                } else {
                    digits[i] = 0;
                }
                i--;
            }
            // 9999....9999
            digits = new int[length + 1];
            digits[0] = 1;
        }
        return digits;
    }

    public static int[] plusOneOptimized(int[] digits) {
        var length = digits.length;
        for (var i = length - 1; i >= 0; i--) {
            // 是9就变成0，不是9就加一
            // 1 2 3 4 5 6 -> 1 2 3 4 5 7
            // 1 2 3 9 9 9 -> 1 2 4 0 0 0
            var digit = digits[i];
            if (digit == 9) {
                digits[i] = 0;
            } else {
                digits[i] = digit + 1;
                return digits;
            }
        }
        // 9999....9999
        digits = new int[length + 1];
        digits[0] = 1;
        return digits;
    }
}
