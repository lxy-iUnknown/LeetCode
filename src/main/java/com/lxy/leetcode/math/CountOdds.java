package com.lxy.leetcode.math;

/**
 * <a href="https://leetcode.cn/problems/count-odd-numbers-in-an-interval-range/">在区间范围内统计奇数数目</a>
 */
public class CountOdds {
    public static int countOdds(int low, int high) {
        var length = high - low + 1;
        // 如果区间长度为偶数，则奇数数目 = 区间长度 / 2
        // 如果区间长度为奇数，且左端点为奇数，则奇数数目 = 区间长度 / 2 + 1
        // 如果区间长度为奇数，且左端点为偶数，则奇数数目 = 区间长度 / 2
        return (length >>> 1) + (length & low & 1);
    }
}
