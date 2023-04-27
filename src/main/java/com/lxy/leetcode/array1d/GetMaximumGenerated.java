package com.lxy.leetcode.array1d;

public class GetMaximumGenerated {
    public static int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            int max = 0;
            int[] result = new int[n + 1];
            result[0] = 0;
            result[1] = 1;
            for (int i = 2; i <= n; i++) {
                int k = i / 2;
                int value;
                if ((i % 2) == 0) {
                    value = result[k];
                } else {
                    value = result[k] + result[k + 1];
                }
                max = Math.max(max, value);
                result[i] = value;
            }
            return max;
        }
    }
}
