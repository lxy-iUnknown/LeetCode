package com.lxy.leetcode.dp;

/**
 * <a href="https://leetcode.cn/problems/min-cost-climbing-stairs/">使用最小花费爬楼梯</a>
 */
public class MinCostClimbingStairs {

    public static int minCostClimbingStairs(int[] cost) {
        var length = cost.length;
        var dp = new int[length];
        dp[0] = 0;
        dp[1] = Math.min(cost[0], cost[1]);
        for (var i = 2; i < length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i], dp[i - 2] + cost[i - 1]);
        }
        return dp[length - 1];
    }

    public static int minCostClimbingStairsOptimized(int[] cost) {
        var dp_0 = 0;
        var dp_1 = Math.min(cost[0], cost[1]);
        for (var i = 2; i < cost.length; i++) {
            var dp = Math.min(dp_1 + cost[i], dp_0 + cost[i - 1]);
            dp_0 = dp_1;
            dp_1 = dp;
        }
        return dp_1;
    }
}
