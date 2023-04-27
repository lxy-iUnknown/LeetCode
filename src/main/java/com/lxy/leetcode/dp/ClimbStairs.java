package com.lxy.leetcode.dp;

public class ClimbStairs {
    // f(1) = 1, f(2) = 2, f(n) = f(n - 1) + f(n - 2)
    public static int climbStairs(int n) {
        int a, b = 0, c = 1;
        for (int i = 1; i <= n; i++) {
            a = b;
            b = c;
            c = a + b;
        }
        return c;
    }
}