package com.lxy.leetcode.math;

/**
 * <a href="https://leetcode.cn/problems/maximum-product-of-three-numbers/">三个数的最大乘积</a>
 */
public class MaximumProduct {
    public static int maximumProduct(int[] nums) {
        // find max1, max2, max3；min1, min2, min3
        // 1. min1 >= 0 -> max1 * max2 * max3
        // 2. max1 < 0 -> max1 * max2 * max3
        // 3. else
        //   1. max1, max2, max3 != 0
        //     1. min1, min2, min3 != 0 -> max(max1 * max2 * max3, max1 * min2 * min3)
        //     2. min3 = 0 -> max1 * max2 * max3
        //     3. min2, min3 = 0 -> max1 * max2 * max3
        //   2. max3 = 0
        //     1. min1, min2, min3 != 0 -> max1 * min2 * min3
        //     2. min3 = 0 -> max1 * min2 * min3
        //     3. min2, min3 = 0 -> 0 ( = max1 * min2 * min3)
        //   3. max2, max3 = 0 ->
        //     1. min1, min2, min3 != 0 -> max1 * min2 * min3
        //     2. min3 = 0 -> max1 * min2 * min3
        //     3. min2, min3 = 0 -> 0  ( = max1 * min2 * min3)

        var max1 = Integer.MIN_VALUE;
        var max2 = Integer.MIN_VALUE;
        var max3 = Integer.MIN_VALUE;

        var min1 = Integer.MAX_VALUE;
        var min2 = Integer.MAX_VALUE;

        for (var num : nums) {
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }

            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }
        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }
}
