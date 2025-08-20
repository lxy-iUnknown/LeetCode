package com.lxy.leetcode.array1d;

public class NumArray {
    private final int[] prefixSum;

    public NumArray(int[] numbers) {
        var length = numbers.length;
        var prefixSum = new int[length];
        var sum = 0;
        for (var i = 0; i < length; i++) {
            sum += numbers[i];
            prefixSum[i] = sum;
        }
        this.prefixSum = prefixSum;
    }

    public int sumRange(int left, int right) {
        var sum = prefixSum[right];
        if (left != 0) {
            sum -= prefixSum[left - 1];
        }
        return sum;
    }
}
