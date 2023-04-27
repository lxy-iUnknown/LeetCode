package com.lxy.leetcode.simulation;

/**
 * <a href="https://leetcode.cn/problems/find-triangular-sum-of-an-array/">数组的三角和</a>
 */
public class TriangularSum {
    public static int triangularSum(int[] numbers) {
        int length = numbers.length;
        while (length > 1) {
            for (int i = 0; i < length - 1; i++) {
                numbers[i] = (numbers[i] + numbers[i + 1]) % 10;
            }
            length--;
        }
        return numbers[0];
    }
}
