package com.lxy.leetcode.array1d;

/**
 * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/">最大利润</a>
 */
public class MaxProfit {
    // 思路：找到所有单调增区间并相加
    public static int maxProfit(int[] prices) {
        int profit = 0;
        int start = 0, end = 1, length = prices.length;
        while (start < length && end < length) {
            while (end < length && prices[end] > prices[end - 1]) {
                end++;
            }
            if (end - start > 1) {
                profit += prices[end - 1] - prices[start];
            }
            start = end;
            end++;
        }
        return profit;
    }

    /**
     * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/solutions/38498/tan-xin-suan-fa-by-liweiwei1419-2/">贪心算法优化</a>
     */
    public static int maxProfitGreedy(int[] prices) {
        int length = prices.length;
        if (length < 2) {
            return 0;
        }
        int profit = 0;
        for (int i = 1; i < length; i++) {
            int delta = prices[i] - prices[i - 1];
            if (delta > 0) {
                profit += delta;
            }
        }
        return profit;
    }
}
