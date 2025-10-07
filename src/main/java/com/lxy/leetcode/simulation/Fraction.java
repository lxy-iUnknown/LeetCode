package com.lxy.leetcode.simulation;

import com.lxy.leetcode.util.MathUtil;

/**
 * <a href="https://leetcode.cn/problems/deep-dark-fraction/">连分数化简</a>
 */
public class Fraction {
    private static final int NUMERATOR = 0;
    private static final int DENOMINATOR = 1;

    private static void calculateFraction(int n, int[] fraction) {
        // n + 1/(a / b) = n + b / a = (a * n + b) / a
        var a = fraction[NUMERATOR];
        fraction[NUMERATOR] = n * a + fraction[DENOMINATOR];
        fraction[DENOMINATOR] = a;
    }

    private static void simplify(int[] fraction) {
        var value = MathUtil.gcd(fraction[NUMERATOR], fraction[DENOMINATOR]);
        if (value != 1) {
            fraction[NUMERATOR] /= value;
            fraction[DENOMINATOR] /= value;
        }
    }

    public static int[] fraction(int[] cont) {
        var i = cont.length - 1;
        var fraction = new int[]{cont[i], 1};
        while (--i >= 0) {
            calculateFraction(cont[i], fraction);
        }
        simplify(fraction);
        return fraction;
    }

    public static int[] fractionOptimized(int[] cont) {
        var i = cont.length - 1;
        var fraction = new int[]{cont[i], 1};
        while (--i >= 0) {
            calculateFraction(cont[i], fraction);
        }
        // GCD can be omitted
        // simplify(fraction);
        return fraction;
    }
}
