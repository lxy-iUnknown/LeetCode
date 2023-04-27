package com.lxy.leetcode.array1d;

/**
 * <a href="https://leetcode.cn/problems/find-pivot-index">数组中心下标</a>
 */
public class PivotIndex {

    private static int sum(int[] numbers, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    public static int pivotIndex(int[] numbers) {
        int length = numbers.length;
        for (int i = 0; i < length; i++) {
            if (sum(numbers, 0, i) == sum(numbers, i + 1, length)) {
                return i;
            }
        }
        return -1;
    }

    public static int pivotIndexPrefixSum(int[] numbers) {
        int sum = 0;
        int length = numbers.length;
        int total = sum(numbers, 0, length);
        for (int i = 0; i < length; i++) {
            if (2 * sum + numbers[i] == total) {
                return i;
            }
            sum += numbers[i];
        }
        return -1;
    }
}
