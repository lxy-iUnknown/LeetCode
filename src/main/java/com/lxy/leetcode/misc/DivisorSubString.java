package com.lxy.leetcode.misc;

/**
 * <a href="https://leetcode.cn/problems/find-the-k-beauty-of-a-number/">找到一个数字的K美丽值</a>
 */
public class DivisorSubString {
    private static final int[] POWER_OF_TEN = new int[]{
            1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000
    };

    public static int divisorSubstrings(int number, int k) {
        // 10 ^ 10 > Integer.MAX_VALUE
        if (k == 10) {
            return 1;
        }
        // Save the original number
        int original = number;
        int power = POWER_OF_TEN[k];
        int limit = POWER_OF_TEN[k - 1];
        int count = 0;
        while (number >= limit) {
            // Get substring
            int substring = number % power;
            if (substring != 0 /* Special case */ &&
                    (original % substring) == 0) {
                count++;
            }
            // Pointer move forward
            number /= 10;
        }
        return count;
    }
}
