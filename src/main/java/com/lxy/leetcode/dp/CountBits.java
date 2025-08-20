package com.lxy.leetcode.dp;

/**
 * <a href="https://leetcode.cn/problems/counting-bits/">比特位计数</a>
 */
public class CountBits {

    private static int numberOfTrailingOnes(int n) {
        return Integer.numberOfTrailingZeros(~n);
    }

    public static int[] countBits(int n) {
        var dp = new int[n + 1];
        for (var i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + (1 - numberOfTrailingOnes(i - 1));
        }
        return dp;
    }

    // f(x) = f(floor(x/2))     (x is even)
    // f(x) = f(floor(x/2)) + 1 (x is odd)
    public static int[] countBitsOptimized(int n) {
        var dp = new int[n + 1];
        for (var i = 1; i <= n; i++) {
            dp[i] = dp[i >> 1] + (i & 1);
        }
        return dp;
    }
}
