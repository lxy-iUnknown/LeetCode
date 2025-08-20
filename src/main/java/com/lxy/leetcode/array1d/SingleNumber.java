package com.lxy.leetcode.array1d;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/single-number/">只出现一次的数字</a>
 */
public class SingleNumber {
    public static int singleNumber(int[] numbers) {
        var length = numbers.length; // 2 * n + 1
        Arrays.sort(numbers, 0, length);
        var i = 0;
        while (i < length - 1) {
            var first = numbers[i++];
            var second = numbers[i++];
            if (first != second) {
                return first;
            }
        }
        return numbers[i];
    }

    public static int singleNumberOptimized(int[] numbers) {
        var result = 0;
        for (var number : numbers) {
            result ^= number;
        }
        return result;
    }
}
