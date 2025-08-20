package com.lxy.leetcode.array1d;

/**
 * <a href="https://leetcode.cn/problems/find-pivot-index/">数组中心下标</a>
 */
public class PivotIndex {

    private static int sum(int[] numbers, int start, int end) {
        var sum = 0;
        for (var i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    public static int pivotIndex(int[] numbers) {
        var length = numbers.length;
        for (var i = 0; i < length; i++) {
            if (sum(numbers, 0, i) == sum(numbers, i + 1, length)) {
                return i;
            }
        }
        return -1;
    }

    public static int pivotIndexPrefixSum(int[] numbers) {
        var sum = 0;
        var length = numbers.length;
        var total = sum(numbers, 0, length);
        for (var i = 0; i < length; i++) {
            if (2 * sum + numbers[i] == total) {
                return i;
            }
            sum += numbers[i];
        }
        return -1;
    }
}
