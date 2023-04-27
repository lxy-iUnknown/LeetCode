package com.lxy.leetcode.simulation;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/separate-the-digits-in-an-array/solutions/">分割数组中数字的数位</a>
 */
public class SeparateDigits {
    // 1 <= numbers[i] <= 10^5
    private static final int MAX_DIGIT_COUNT = 6;

    private static int appendDigits(int[] digits, int index, int number) {
        final int MAX_DIGIT_COUNT = 10;

        int tempIndex = MAX_DIGIT_COUNT - 1;
        int[] tempDigits = new int[MAX_DIGIT_COUNT];
        // Generate digits in a reversed order
        while (number >= 10) {
            int temp = number / 10;
            tempDigits[tempIndex--] = number - temp * 10;
            number = temp;
        }
        tempDigits[tempIndex--] = number;
        // Copy digits
        while (++tempIndex < MAX_DIGIT_COUNT) {
            digits[index++] = tempDigits[tempIndex];
        }
        return index;
    }

    @SuppressWarnings("ForLoopReplaceableByForEach")
    public static int[] separateDigits(int[] numbers) {
        int length = numbers.length;
        int[] digits = new int[length * MAX_DIGIT_COUNT];
        int index = 0;
        for (int i = 0; i < length; i++) {
            index = appendDigits(digits, index, numbers[i]);
        }
        return Arrays.copyOf(digits, index);
    }
}
