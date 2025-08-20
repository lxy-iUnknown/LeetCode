package com.lxy.leetcode.simulation;

/**
 * <a href="https://leetcode.cn/problems/WHnhjV/">宝石补给</a>
 */
public class GiveGem {
    public static int giveGem(int[] gem, int[][] operations) {
        final var DONOR = 0;
        final var RECIPIENT = 1;

        for (var operation : operations) {
            var donorIndex = operation[DONOR];
            var gemCount = gem[donorIndex] / 2;
            gem[donorIndex] -= gemCount;
            gem[operation[RECIPIENT]] += gemCount;
        }
        // 0 <= gem[i] <= 10^3
        var max = 0;
        var min = 1000;
        for (var gemCount : gem) {
            if (gemCount < min) {
                min = gemCount;
            }
            if (gemCount > max) {
                max = gemCount;
            }
        }
        return max - min;
    }
}
