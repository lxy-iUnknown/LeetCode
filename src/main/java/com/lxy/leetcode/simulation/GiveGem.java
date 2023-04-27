package com.lxy.leetcode.simulation;

public class GiveGem {
    public static int giveGem(int[] gem, int[][] operations) {
        final int DONOR = 0;
        final int RECIPIENT = 1;

        for (int[] operation : operations) {
            int donorIndex = operation[DONOR];
            int gemCount = gem[donorIndex] / 2;
            gem[donorIndex] -= gemCount;
            gem[operation[RECIPIENT]] += gemCount;
        }
        // 0 <= gem[i] <= 10^3
        int max = 0, min = 1000;
        for (int gemCount : gem) {
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
