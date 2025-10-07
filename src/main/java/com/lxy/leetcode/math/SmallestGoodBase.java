package com.lxy.leetcode.math;

/**
 * <a href="https://leetcode.cn/problems/smallest-good-base/">最小好进制</a>
 */
public class SmallestGoodBase {
    private static long radixFunc(long k, int m, long n) {
        var sum = 1L;
        var power = 1L;
        for (var i = 1; i < m; i++) {
            power *= k;
            sum += power;
        }
        return sum - n;
    }

    private static int floorLog2(long x) {
        return 63 - Long.numberOfLeadingZeros(x);
    }

    /**
     * 求最小好进制<br>
     * 设进制为k，数字长度为m，则k<sup>m - 1</sup> + k<sup>m - 2</sup>
     * + ... + k<sup>2</sup> + k + 1
     * 易知：<br>
     * 1. n &ge; 3 <br>
     * 2. m &le; floor(log2(n + 1)) <br>
     * 设f(k) = k<sup>m - 1</sup> + k<sup>m - 2</sup>
     * + ... + k<sup>2</sup> + k + (1 - n)
     * ，显然f(k)单调递增<br>
     * 易知：<br>
     * 1. f(1) = m - n < 0<br>
     * 2. f(n<sup>1 / (m - 1)</sup>)
     * = n + n<sup>(m - 2) / (m - 1)</sup>+ ... + n<sup>2 / (m - 1)</sup> + n<sup>1 / (m - 1)</sup> + (1 - n)
     * = n<sup>(m - 2) / (m - 1)</sup>+ ... + n<sup>2 / (m - 1)</sup> + n<sup>1 / (m - 1)</sup> + 1 > 0<br>
     * 所以f(k)在[0, n<sup>1 / (m - 1)</sup>]内存在唯一解<br>
     * 算法：首先遍历m，其次使用二分法判断是否存在另一个较大的m使得f(k)有整数解<br>
     * @param n 输入的数字
     * @return 最小好进制
     */
    public static long smallestGoodBase(long n) {
        var floorLog2 = floorLog2(n + 1);
        for (var m = floorLog2; m >= 2; m--) {
            var startK = 1L;
            // ceil(x) >= x, f(x) > 0 -> f(ceil(x)) > 0
            var endK = (long) Math.ceil(Math.pow(n, 1.0 / (m - 1)));
            while (endK - startK > 1) {
                // avoid overflow
                var midK = startK + (endK - startK) / 2;
                var midValue = radixFunc(midK, m, n);
                if (midValue == 0) {
                    return midK;
                }
                else if (midValue > 0) {
                    endK = midK;
                } else {
                    startK = midK;
                }
            }
        }
        return n - 1;
    }
}
