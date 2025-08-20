package com.lxy.leetcode.string;

/**
 * <a href="https://leetcode.cn/problems/reverse-integer/">整数反转</a>
 */
public class ReverseInteger {

    /**
     * Reverse digits (sign is preserved) of a number. This algorithm is modified from {@link Integer#parseInt(String, int)}
     *
     * @param number Input number
     * @return Reversed number. If overflow occurred, this method will return 0
     */
    public static int reverseInteger(int number) {
        final var RADIX = 10;
        final int MAX_DIGIT_COUNT = 10; // Digit count of Integer.MAX_VALUE
        final int MULTIPLY_LIMIT = -214748364; // -Integer.MAX_VALUE / RADIX == Integer.MIN_VALUE / RADIX

        // Special case: Math.abs(number) will overflow
        if (number == Integer.MIN_VALUE) {
            return 0;
        }
        int limit;
        var negative = number < 0;
        if (negative) {
            number = -number;
            limit = -Integer.MAX_VALUE;
        } else {
            limit = Integer.MIN_VALUE;
        }
        // Generate digits in a reversed order
        var endIndex = MAX_DIGIT_COUNT - 1;
        var digits = new byte[MAX_DIGIT_COUNT];
        while (number != 0) {
            var temp = number / RADIX;
            digits[endIndex--] = (byte) (number - temp * RADIX);
            number = temp;
        }
        // Parse integer in a reversed order
        var result = 0;
        for (var index = MAX_DIGIT_COUNT - 1; index > endIndex; index--) {
            var digit = digits[index];
            if (result < MULTIPLY_LIMIT) {
                return 0;
            }
            result *= RADIX;
            if (result < limit + digit) {
                return 0;
            }
            result -= digit;
        }
        return negative ? result : -result;
    }

    public static int reverseIntegerOptimized(int number) {
        final var RADIX = 10;

        final int MULTIPLY_LIMIT_POSITIVE = Integer.MAX_VALUE / RADIX;
        final int MULTIPLY_LIMIT_NEGATIVE = Integer.MIN_VALUE / RADIX;

        var result = 0;
        while (number != 0) {
            var temp = number / RADIX;
            if (result < MULTIPLY_LIMIT_NEGATIVE || result > MULTIPLY_LIMIT_POSITIVE) {
                return 0;
            }
            result = result * RADIX + (number - temp * RADIX);
            number = temp;
        }
        return result;
    }
}