package com.lxy.leetcode.array1d;

/**
 * <a href="https://leetcode.cn/problems/get-maximum-in-generated-array/">获取生成数组中的最大值</a>
 */
public class GetMaximumGenerated {
    public static int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            var max = 0;
            var result = new int[n + 1];
            result[0] = 0;
            result[1] = 1;
            for (var i = 2; i <= n; i++) {
                var k = i / 2;
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
