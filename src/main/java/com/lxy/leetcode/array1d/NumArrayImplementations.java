package com.lxy.leetcode.array1d;

import com.lxy.leetcode.util.Util;

/**
 * <a href="https://leetcode.cn/problems/range-sum-query-immutable/">区域和检索 - 数组不可变</a>
 */
public class NumArrayImplementations {

    public static class NumArray {
        private final int[] prefixSum;

        public NumArray(int[] numbers) {
            int length = numbers.length;
            int[] prefixSum = new int[length];
            int sum = 0;
            for (int i = 0; i < length; i++) {
                sum += numbers[i];
                prefixSum[i] = sum;
            }
            this.prefixSum = prefixSum;
        }

        public int sumRange(int left, int right) {
            int sum = prefixSum[right];
            if (left != 0) {
                sum -= prefixSum[left - 1];
            }
            return sum;
        }

        @Override
        public String toString() {
            return Util.toSimpleString(this);
        }
    }
    public static class NumArraySimple {
        private final int[] prefixSum;

        public NumArraySimple(int[] numbers) {
            int length = numbers.length;
            // 第0个位置空出来
            int[] prefixSum = new int[length + 1];
            int sum = 0;
            for (int i = 0; i < length; i++) {
                sum += numbers[i];
                prefixSum[i + 1] = sum;
            }
            this.prefixSum = prefixSum;
        }

        public int sumRange(int left, int right) {
            return prefixSum[right + 1] - prefixSum[left];
        }

        @Override
        public String toString() {
            return Util.toSimpleString(this);
        }
    }
}
