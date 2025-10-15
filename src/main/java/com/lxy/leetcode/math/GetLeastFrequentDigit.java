package com.lxy.leetcode.math;

/**
 * <a href="https://leetcode.cn/problems/find-the-least-frequent-digit/">出现频率最低的数字</a>
 */
public class GetLeastFrequentDigit {
    public static int getLeastFrequentDigit(int n) {
        var table = new int[10];
        while (n != 0) {
            var div = n / 10;
            table[n - div * 10]++;
            n = div;
        }
        var index = 0;
        var min = Integer.MAX_VALUE;
        for (var i = 0; i < 10; i++) {
            var freq = table[i];
            if (freq != 0 && freq < min) {
                index = i;
                min = freq;
            }
        }
        return index;
    }
}
