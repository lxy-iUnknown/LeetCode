package com.lxy.leetcode.math;

/**
 * <a href="https://leetcode.cn/problems/count-numbers-with-unique-digits/">连续整数求和</a>
 */
public class ConsecutiveNumbersSum {
    private static int floorDiv2(int n) {
        return n >>> 1;
    }

    private static boolean isOdd(int n) {
        return (n & 1) != 0;
    }

    /**
     * 算法：<br>
     * n = a<sub>1</sub> + a<sub>2</sub> + ... + a<sub>k</sub><br>
     * &nbsp;&nbsp;&nbsp;= (a<sub>1</sub> + a<sub>k</sub>) * k / 2<br>
     * &nbsp;&nbsp;&nbsp;= (a<sub>1</sub> + a<sub>1</sub> + (k - 1)) * k / 2<br>
     * &nbsp;&nbsp;&nbsp;= (2a<sub>1</sub> + (k - 1)) * k / 2<br>
     * &nbsp;&nbsp;&nbsp;= ka<sub>1</sub> + k(k - 1) / 2<br>
     * 整理得：a<sub>1</sub> = (n - k * (k - 1)) / k = (2n - k * (k - 1)) / 2k<br>
     * 显然a<sub>1</sub> > 0, 即n - k * (k - 1) / 2 > 0<br>
     * 即：k<sup>2</sup> - k - 2n < 0<br>
     * 判别式&Delta; = 1<sup>2</sup> - 4 * 1 * (-2n) = 1 + 8n > 0，因此该方程有两个不等实根<br>
     * x<sub>1</sub> = (-1 - sqrt(1 + 8n)) / 2 < 0<br>
     * x<sub>2</sub> = (-1 + sqrt(1 + 8n)) / 2 > (-1 + sqrt(1 + 8 * 1)) / 2 = 1 > 0<br>
     * 解得：k < (-1 + sqrt(1 + 8n)) / 2
     *
     */
    private static int computeMaximumK(int n) {
        // use long to avoid overflow
        return (int) ((-1 + Math.sqrt(1 + 8 * (long) n)) / 2);
    }

    public static int consecutiveNumbersSum(int n) {
        var sum = 0;
        for (var k = 1; k <= computeMaximumK(n); k++) {
            var divisor = n - floorDiv2(k * (k - 1));
            if ((divisor % k) == 0) {
                sum++;
            }
        }
        return sum;
    }

    /**
     * 注意到a<sub>1</sub> = (2n - k * (k - 1)) / 2k。如果2n不是k的倍数则该方程无整数解<br>
     * 设2n = k * p，则：<br>
     * a<sub>1</sub> = (2n - k * (k - 1)) / 2k<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;= (p * k - k * (k - 1)) / 2k<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;= (p - (k - 1)) / 2<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;= (p - k + 1) / 2<br>
     * 因此，在2n是k的倍数的情况下，只有p - k为奇数时该方程才有整数解
     *
     */
    public static int consecutiveNumbersSumOptimized(int n) {
        var sum = 0;
        var maxK = computeMaximumK(n);
        n *= 2;
        for (var k = 1; k <= maxK; k++) {
            var div = n / k;
            var rem = n - div * k;
            if (rem == 0 && isOdd(div - k)) {
                sum++;
            }
        }
        return sum;
    }
}
