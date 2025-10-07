package com.lxy.leetcode.math;

/**
 * <a href="https://leetcode.cn/problems/ccw6C7/">黑白方格画</a>
 */
public class PaintingPlan {
    private static final int[] FACTORIAL = new int[]{
            1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600
    };

    private static int comb(int n, int r) {
        return FACTORIAL[n] / (FACTORIAL[r] * FACTORIAL[n - r]);
    }

    public static int paintingPlan(int n, int k) {
        // https://leetcode.cn/problems/ccw6C7/solutions/721910/qian-yang-hei-bai-hua-si-lu-ji-jian-bao-eh8v9/
        if (k == n * n) {
            return 1;
        }
        var rest = n * n - k;
        var sum = 0;
        for (var p = 1; p <= (int) Math.sqrt(rest); p++) {
            var div = rest / p;
            if (rest - div * p == 0 && div <= n) {
                var plans = comb(n, p) * comb(n, div);
                if (p != div) {
                    plans *= 2;
                }
                sum += plans;
            }
        }
        return sum;
    }
}
