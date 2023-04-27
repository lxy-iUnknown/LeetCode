package com.lxy.leetcode.simulation;

/**
 * <a href="https://leetcode.cn/problems/water-bottles">换水问题</a>
 */
public class NumWaterBottles {
    public static int numWaterBottles(int numBottles, int numExchange) {
        int total = 0;
        int numEmptyBottles = 0;
        for (;;) {
            // Drink water
            total += numBottles;
            numEmptyBottles += numBottles;
            // Exchange water
            if (numEmptyBottles < numExchange) {
                break;
            }
            int div = numEmptyBottles / numExchange;
            int rem = numEmptyBottles - div * numExchange;
            numBottles = div;
            numEmptyBottles = rem;
        }
        return total;
    }

    // 设酒瓶数量为n，每e个酒瓶可以换1个酒瓶。
    // 每e个酒瓶可以换1个酒瓶也就相当于每减少e-1瓶酒，就可以换一瓶酒。那一共能换n/(e-1)瓶。
    // 但有个前提，就是最后至少得有e瓶酒才可以兑换，所以如果最后只剩e-1瓶酒的时候就不能换了。
    // 为了处理这个问题，我们应该用(n-1)/(e-1)，这样最后只剩e-1瓶酒的时候，就不足以被e-1整除而多兑换一次了
    public static int numWaterBottlesOptimized(int numBottles, int numExchange) {
        return numBottles + (numBottles - 1) / (numExchange - 1);
    }
}
