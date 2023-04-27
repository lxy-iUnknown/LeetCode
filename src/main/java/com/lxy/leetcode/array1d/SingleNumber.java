package com.lxy.leetcode.array1d;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/single-number">只出现一次的数字</a>
 */
public class SingleNumber {
    public static int singleNumber(int[] numbers) {
        int length = numbers.length; // 2 * n + 1
        Arrays.sort(numbers, 0, length);
        int i = 0;
        while (i < length - 1) {
            int first = numbers[i++];
            int second = numbers[i++];
            if (first != second) {
                return first;
            }
        }
        return numbers[i];
    }

    public static int singleNumberOptimized(int[] numbers) {
        int result = 0;
        for (int number : numbers) {
            result ^= number;
        }
        return result;
    }
}
