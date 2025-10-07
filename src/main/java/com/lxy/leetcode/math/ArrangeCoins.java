package com.lxy.leetcode.math;


/**
 * <a href="https://leetcode.cn/problems/arranging-coins/">排列硬币</a>
 */
public class ArrangeCoins {
    public static int arrangeCoins(int n) {
        // 1 + 2 + ... + k <= n
        // (1 + k) * k / 2 <= n
        // k ^ 2 + k <= 2n
        // k ^ 2 + k - 2n <= 0
        // delta = 1 ^ 2 - 4 * 1 * (-4n) = 1 + 8n > 0
        // x1 = (-1 - sqrt(1 + 8n)) / 2
        // x2 = (-1 + sqrt(1 + 8n)) / 2
        // k <= (-1 + sqrt(1 + 8n)) / 2
        return (int) (-0.5 + Math.sqrt(1 + 8 * (long) n) / 2);
    }
}
