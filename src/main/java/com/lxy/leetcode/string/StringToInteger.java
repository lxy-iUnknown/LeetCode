package com.lxy.leetcode.string;

/**
 * <a href="https://leetcode.cn/problems/string-to-integer-atoi/">字符串转整数</a>
 */
public class StringToInteger {
    public static int stringToInteger(String s) {
        final var RADIX = 10;
        final int MULTIPLY_LIMIT = -214748364; // Integer.MIN_VALUE / RADIX == -Integer.MAX_VALUE / RADIX

        var length = s.length();
        var result = 0;
        var i = 0;
        var limit = -Integer.MAX_VALUE;
        var negative = false;
        while (i < length) {
            var ch = s.charAt(i++);
            if (ch == '-') {
                limit = Integer.MIN_VALUE;
                negative = true;
                break;
            } else if (ch == '+') {
                break;
            } else if (ch >= '0' && ch <= '9') {
                i--;
                break;
            } else if (ch != ' ') {
                return 0;
            }
        }
        while (i < length) {
            var digit = (char) (s.charAt(i++) - '0');
            if (digit > RADIX - 1) {
                break;
            }
            if (result < MULTIPLY_LIMIT) {
                // Overflow occurred
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result *= RADIX;
            if (result < limit + digit) {
                // Overflow occurred
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result -= digit;
        }
        return negative ? result : -result;
    }

    public static int stringToIntegerOptimized(String s) {
        final var RADIX = 10;

        var length = s.length();
        var result = 0;
        var i = 0;
        var negative = false;
        while (i < length) {
            var ch = s.charAt(i++);
            if (ch == '-') {
                negative = true;
                break;
            } else if (ch == '+') {
                break;
            } else if (ch >= '0' && ch <= '9') {
                i--;
                break;
            } else if (ch != ' ') {
                return 0;
            }
        }
        while (i < length) {
            var digit = (char) (s.charAt(i++) - '0');
            if (digit > RADIX - 1) {
                break;
            }
            if (result > (Integer.MAX_VALUE - digit) / RADIX) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result = result * RADIX + digit;
        }
        return negative ? -result : result;
    }
}
