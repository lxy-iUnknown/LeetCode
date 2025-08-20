package com.lxy.leetcode.simulation;

/**
 * <a href="https://leetcode.cn/problems/can-place-flowers/">种花问题</a>
 */
public class CanPlaceFlowers {

    public static boolean canPlaceFlowers(int[] flowerBed, int n) {
        var i = 0;
        var length = flowerBed.length;
        while (i < length && n > 0) {
            var flower = flowerBed[i];
            var nextFlower = i + 1 >= length ? 0 /* sentinel */ : flowerBed[i + 1];
            if (flower == 0) {
                if (nextFlower == 1) {
                    // Move three steps
                    i += 3;
                    continue;
                } else {
                    // Plant a flower
                    n--;
                }
            }
            // Otherwise, move two steps
            i += 2;
        }
        // Test if there is more flower to plant
        return n == 0;
    }
}
