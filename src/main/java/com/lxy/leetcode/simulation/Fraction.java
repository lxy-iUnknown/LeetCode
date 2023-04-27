package com.lxy.leetcode.simulation;

/**
 * <a href="https://leetcode.cn/problems/deep-dark-fraction/">连分数化简</a>
 */
public class Fraction {
    private static final int NUMERATOR = 0;
    private static final int DENOMINATOR = 1;

    private static int gcd(int m, int n) {
        if (m < n) {
            // Use swap instead of recursion
            int temp = n;
            n = m;
            m = temp;
        }
        return n == 0 ? m : gcd(n, m % n);
    }

    private static void calculateFraction(int n, int[] fraction) {
        // n + 1/(a / b) = n + b / a = (a * n + b) / a
        int a = fraction[NUMERATOR];
        fraction[NUMERATOR] = n * a + fraction[DENOMINATOR];
        fraction[DENOMINATOR] = a;
    }

    private static void simplify(int[] fraction) {
        int value = gcd(fraction[NUMERATOR], fraction[DENOMINATOR]);
        if (value != 1) {
            fraction[NUMERATOR] /= value;
            fraction[DENOMINATOR] /= value;
        }
    }

    public static int[] fraction(int[] cont) {
        int i = cont.length - 1;
        int[] fraction = new int[]{cont[i], 1};
        while (--i >= 0) {
            calculateFraction(cont[i], fraction);
        }
        simplify(fraction);
        return fraction;
    }

    public static int[] fractionOptimized(int[] cont) {
        int i = cont.length - 1;
        int[] fraction = new int[]{cont[i], 1};
        while (--i >= 0) {
            calculateFraction(cont[i], fraction);
        }
        // GCD can be omitted
        // simplify(fraction);
        return fraction;
    }
}
