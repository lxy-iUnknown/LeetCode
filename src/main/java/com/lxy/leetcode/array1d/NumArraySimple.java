package com.lxy.leetcode.array1d;

public class NumArraySimple {
    private final int[] prefixSum;

    public NumArraySimple(int[] numbers) {
        var length = numbers.length;
        // 第0个位置空出来
        var prefixSum = new int[length + 1];
        var sum = 0;
        for (var i = 0; i < length; i++) {
            sum += numbers[i];
            prefixSum[i + 1] = sum;
        }
        this.prefixSum = prefixSum;
    }

    public int sumRange(int left, int right) {
        return prefixSum[right + 1] - prefixSum[left];
    }
}
