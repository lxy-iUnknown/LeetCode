package com.lxy.leetcode.math;

/**
 * <a href="https://leetcode.cn/problems/distribute-candies-among-children-i">给小朋友们分糖果</a>
 */
public class DistributeCandies {
    /**
     * 设a, b, c ∈ [0, k], a + b + c = n，求该方程的整数解对数<br>
     * 0 &le; a &le; k, b + c = n - a &le; 2n -> max(0, n - 2k) &le; a &le; min(k, n)<br>
     * 0 &le; b &le; k, 0 &le; c = n - a - b &le; k -> max(0, n - a - k) &le; k &le; min(n - a, k) =  min(0, n - a - k) + k<br>
     * 于是s = sum(max(0, n - 2k), min(k, n), min(0, n - a - k) - max(0, n - a - k) + (k + 1))<br>
     * 情况一：n &le; k<br>
     * 此时有：<br>
     * max(0, n - 2k) = 0, min(k, n) = n<br>
     * -k &le; n - a - k &le; n - k &le; 0<br>
     * s = sum(0, n, n - a - k + (k + 1))<br>
     * &nbsp;&nbsp;= sum(0, n, n - a + 1)<br>
     * &nbsp;&nbsp;= (n + 1)(n + 1) - n(n + 1) / 2<br>
     * &nbsp;&nbsp;= (n + 1)(n + 2) / 2<br>
     * 情况二：k < n &le; 2k<br>
     * 此时有：<br>
     * max(0, n - 2k) = 0, min(k, n) = k<br>
     * n - 2k &le; n - a - k &le; n - k, n - 2k < 0, n - k > 0<br>
     * 此时需要讨论n - a - k的符号：<br>
     * 1. 当n - a - k < 0, 即a > n - k时：<br>
     * min(0, n - a - k) - max(0, n - a - k) + (k + 1) = (n - a - k) + (k + 1) = n - a + 1<br>
     * s<sub>1</sub> = sum(n - k + 1, k, n - a + 1)
     * &nbsp;&nbsp;=(2k - n)(n + 1) - (n - k + 1 + k)(2k - n) / 2<br>
     * &nbsp;&nbsp;=(2k - n)(n + 1) - (n + 1)(2k - n) / 2<br>
     * &nbsp;&nbsp;=(n + 1)(2k - n) / 2<br>
     * 2. 当n - a - k &ge; 0, 即a &le; n - k时：<br>
     * min(0, n - a - k) - max(0, n - a - k) + (k + 1) = 0 - (n - a - k) + (k + 1) = 2k - n + 1 + a<br>
     * s<sub>2</sub> = sum(0, n - k, 2k - n + 1 + a)
     * &nbsp;&nbsp;=(n - k + 1)(2k - n + 1) + (n - k + 1)(n - k) / 2<br>
     * &nbsp;&nbsp;=(n - k + 1)(4k - 2n + 2 + n - k) / 2<br>
     * &nbsp;&nbsp;=(n - k + 1)(3k - n + 2) / 2<br>
     * s = s<sub>1</sub> + s<sub>2</sub><br>
     * &nbsp;&nbsp;= (n + 1)(2k - n) / 2 + (n - k + 1)(3k - n + 2) / 2<br>
     * &nbsp;&nbsp;= ((2kn + 2k - n<sup>2</sup> - n) + (3kn - 3k<sup>2</sup> + 3k - n<sup>2</sup> + kn - n + 2n - 2k + 2)) / 2<br>
     * &nbsp;&nbsp;= (-2n<sup>2</sup> - 3k<sup>2</sup> + 6kn + 3k + 2) / 2<br>
     * &nbsp;&nbsp;= (2(n(3k - n) + 1) - 3k(k + 1)) / 2<br>
     * &nbsp;&nbsp;= n(3k - n) + 1 - 3k(k + 1) / 2<br>
     * 情况三：2k < n &le; 3k<br>
     * 此时有：<br>
     * max(0, n - 2k) = n - 2k, min(k, n) = k<br>
     * 0 &le; n - 2k &le; n - a - k &le; k<br>
     * s = sum(n - 2k, k, 0 - (n - a - k) + (k + 1)<br>
     * &nbsp;&nbsp;= sum(n - 2k, k, 2k - n + 1 + a)<br>
     * &nbsp;&nbsp;= (3k - n + 1)(2k - n + 1) + (n - 2k + k)(3k - n + 1) / 2<br>
     * &nbsp;&nbsp;= (3k - n + 1)(2 * (2k - n + 1) + (n - k)) / 2<br>
     * &nbsp;&nbsp;= (3k - n + 1)(4k - 2n + 2 + n - k) / 2<br>
     * &nbsp;&nbsp;= (3k - n + 1)(3k - n + 2) / 2<br>
     * 情况四：n > 3k<br>
     * 此时有：max(0, n - 2k) - min(k, n) = (n - 2k) - k = n - 3k < 0，此时s = 0
     *
     */
    public static int distributeCandies(int n, int limit) {
        if (n <= limit) {
            return (n + 1) * (n + 2) / 2;
        } else if (n <= 2 * limit) {
            return n * (3 * limit - n) - 3 * limit * (limit - 1) / 2 + 1;
        } else if (n <= 3 * limit) {
            var p = 3 * limit - n;
            return (p + 1) * (p + 2) / 2;
        } else {
            return 0;
        }
    }
}
