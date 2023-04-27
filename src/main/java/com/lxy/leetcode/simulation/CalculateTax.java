package com.lxy.leetcode.simulation;

/**
 * <a href="https://leetcode.cn/problems/calculate-amount-paid-in-taxes/solutions/">计算应缴税款总额</a>
 */
public class CalculateTax {
    private static final int UPPER = 0;
    private static final int PERCENT = 1;

    public static double calculateTax(int[][] brackets, int income) {
        // Use fixed point arithmetic to improve performance
        // Precondition: 0 <= income <= 1000
        // So result will less than 1000 * 100 = 100000, which will not overflow
        int result = 0;
        int[] bracket = brackets[UPPER];
        int upper = Math.min(income, bracket[UPPER]);
        result += upper * bracket[PERCENT];
        income -= upper;
        for (int i = 1; i < brackets.length; i++) {
            if (income <= 0) {
                break;
            }
            bracket = brackets[i];
            int delta = Math.min(income, bracket[UPPER] - brackets[i - 1][UPPER]);
            result += delta * bracket[PERCENT];
            income -= delta;
        }
        return result / 100.0;
    }
}
