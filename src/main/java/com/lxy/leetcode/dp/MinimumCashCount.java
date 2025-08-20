package com.lxy.leetcode.dp;

/**
 * 假设你身上带了足够多的1、5、11元的钞票，要求用尽量少的钞票数量凑出n元(n&ge;0)
 */
public class MinimumCashCount {
    private static final int TYPE_A = 1;
    private static final int TYPE_B = 5;
    private static final int TYPE_C = 11;

    public static int minimumCashCount(int n) {
        if (n < TYPE_A) {
            return 0;
        }
        var dp = new int[n + 1];
        for (var i = 1; i <= n; i++) {
            var count = Integer.MAX_VALUE;
            if (i >= TYPE_A) {
                count = Math.min(count, dp[i - TYPE_A] + 1);
            }
            if (i >= TYPE_B) {
                count = Math.min(count, dp[i - TYPE_B] + 1);
            }
            if (i >= TYPE_C) {
                count = Math.min(count, dp[i - TYPE_C] + 1);
            }
            dp[i] = count;
        }
        return dp[n];
    }

    /**
     * 将空间复杂度由{@link MinimumCashCount#minimumCashCount(int)}的O(n)优化为O(1)
     */
    public static int minimumCashCountCyclicBuffer(int n) {
        final var SIZE = TYPE_C + 1;

        if (n < TYPE_A) {
            return 0;
        }
        var dp = new int[SIZE];
        for (var i = 1; i <= n; i++) {
            var count = Integer.MAX_VALUE;
            if (i >= TYPE_A) {
                count = Math.min(count, dp[(i - TYPE_A) % SIZE] + 1);
            }
            if (i >= TYPE_B) {
                count = Math.min(count, dp[(i - TYPE_B) % SIZE] + 1);
            }
            if (i >= TYPE_C) {
                count = Math.min(count, dp[(i - TYPE_C) % SIZE] + 1);
            }
            dp[i % SIZE] = count;
        }
        return dp[n % SIZE];
    }
}
