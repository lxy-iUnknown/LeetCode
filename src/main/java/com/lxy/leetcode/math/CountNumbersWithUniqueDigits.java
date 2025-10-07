package com.lxy.leetcode.math;

/**
 * <a href="https://leetcode.cn/problems/count-numbers-with-unique-digits/">统计各位数字都不同的数字个数</a>
 */
public class CountNumbersWithUniqueDigits {
    private static final int MAX = 8877691;

    private static final int[] TABLE = {
            1, 10, 91, 739, 5275, 32491, 168571, 712891, 2345851, 5611771, MAX
    };

    /**
     * 已知整数n，计算[0, 10<sup>n</sup>)中各位数字都不同的数字的个数<br>
     * 算法：<br>
     * 设f(n)为[10<sup>n - 1</sup>, 10<sup>n</sup>)中各位数字都不同的数字的个数（n &ge; 1），则：<br>
     * 1. 当n > 10时由鸽巢原理可知f(n) = 0<br>
     * 2. 通过枚举n位数的各个位可知，f(n) = 9 * npr(9, n - 1)<br>
     * 设g(n)为[0, 10<sup>n</sup>)中各位数字都不同的数字的个数，
     * 则g(n) = sum(f(i), i, 1, n) + 1<br>
     * @param n 整数n
     * @return 各位数字都不同的数字个数
     */
    public static int countNumbersWithUniqueDigits(int n) {
        var sum = 1;
        var perm = 1;
        var value = 9;
        for (var i = 0; i < n; i++) {
            sum += 9 * perm;
            perm *= value;
            value--;
        }
        return sum;
    }

    public static int countNumbersWithUniqueDigitsTable(int n) {
        return n > 10 ? MAX : TABLE[n];
    }
}
