package com.lxy.leetcode.math;

/**
 * <a href="https://leetcode.cn/problems/maximum-difference-by-remapping-a-digit/">替换一个数字后的最大差值</a>
 */
public class MinMaxDifference {
    public static int minMaxDifference(int num) {
        // 最大值：从高位到低位找到第一个不是9的数字替换成9（为了比原本的数更大）
        // 最小值：最高位的数字替换成0

        // 第一步：寻找最大值和最小值的新数位
        var newMaxDigit = -1;
        var newMinDigit = -1;
        var n = num;
        while (n >= 10) {
            var div = n / 10;
            var digit = n - div * 10;
            if (digit != 9) {
                newMaxDigit = digit;
            }
            n = div;
        }
        // 最高位
        if (n != 9) {
            newMaxDigit = n;
        }
        newMinDigit = n;
        // 第二步：替换相应数位
        var max = num;
        var min = num;
        var power = 1;
        while (num > 0) {
            var div = num / 10;
            var digit = num - div * 10;
            if (digit == newMaxDigit) {
                max += (9 - newMaxDigit) * power;
            }
            if (digit == newMinDigit) {
                min -= newMinDigit * power;
            }
            num = div;
            power *= 10;
        }
        return max - min;
    }
}
