package com.lxy.leetcode.array1d;

/**
 * <a href="https://leetcode.cn/problems/max-consecutive-ones/">最大连续1的个数</a>
 */
public class MaxConsecutiveOnes {
    private static int nextOne(int[] numbers, int length, int i) {
        while (i < length && numbers[i] == 0) {
            i++;
        }
        return i;
    }

    private static int nextConsecutiveOnes(int[] numbers, int length, int i) {
        while (i < length && numbers[i] != 0 /* == 1 */) {
            i++;
        }
        return i;
    }

    public static int findMaxConsecutiveOnes(int[] numbers) {
        var max = 0;
        var length = numbers.length;
        var start = nextOne(numbers, length, 0);
        while (start < length) {
            var end = nextConsecutiveOnes(numbers, length, start);
            var oneCount = end - start;
            if (oneCount > max) {
                max = oneCount;
            }
            start = nextOne(numbers, length, end);
        }
        return max;
    }

    public static int findMaxConsecutiveOnesSimplified(int[] numbers) {
        var maxOnes = 0;
        var ones = 0;
        for (var number : numbers) {
            if (number == 1) {
                ones++;
            } else {
                // Update value
                if (ones > maxOnes) {
                    maxOnes = ones;
                }
                ones = 0;
            }
        }
        // Update final value
        if (ones > maxOnes) {
            maxOnes = ones;
        }
        return maxOnes;
    }
}