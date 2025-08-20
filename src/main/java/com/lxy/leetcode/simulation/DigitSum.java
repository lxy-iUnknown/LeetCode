package com.lxy.leetcode.simulation;

/**
 * <a href="https://leetcode.cn/problems/calculate-digit-sum-of-a-string/">计算字符串的数字和</a>
 */
public class DigitSum {
    private static int appendDigits(char[] digits, int index, int number) {
        final int MAX_DIGIT_COUNT = 10;

        var tempIndex = MAX_DIGIT_COUNT - 1;
        var tempDigits = new char[MAX_DIGIT_COUNT];
        // Generate digits in a reversed order
        while (number >= 10) {
            var temp = number / 10;
            tempDigits[tempIndex--] = (char) ('0' + number - temp * 10);
            number = temp;
        }
        tempDigits[tempIndex--] = (char) ('0' + number);
        // Copy digits
        while (++tempIndex < MAX_DIGIT_COUNT) {
            digits[index++] = tempDigits[tempIndex];
        }
        return index;
    }

    public static String digitSum(String s, int k) {
        var length = s.length();
        // Digit buffer(reusable)
        var digits = s.toCharArray();
        while (length > k) {
            var index = 0;
            // Iterate string parts
            for (var i = 0; i < length; i += k) {
                // Compute digit sum
                var sum = 0;
                for (var j = i; j < Math.min(i + k, length); j++) {
                    sum += digits[j] - '0';
                }
                // Append digit sum(this operation will not overwrite next digits)
                index = appendDigits(digits, index, sum);
            }
            // Set new string length
            length = index;
        }
        return new String(digits, 0, length);
    }
}
