package com.lxy.leetcode.dp;

/**
 * <a href="https://leetcode.cn/classic/problems/climbing-stairs/">爬楼梯</a>
 */
public class ClimbStairs {
    // f(1) = 1, f(2) = 2, f(n) = f(n - 1) + f(n - 2)
    public static int climbStairs(int n) {
        var a = 0;
        var b = 0;
        var c = 1;
        for (var i = 1; i <= n; i++) {
            a = b;
            b = c;
            c = a + b;
        }
        return c;
    }
}