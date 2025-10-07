package com.lxy.leetcode.math;

public class FindMissingAndRepeatedValues {
    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        // 1 + 2 + ... + n = n(n + 1) / 2
        // 1^2 + 2^2 + ... + n^2 = n(n + 1)(2n + 1) / 6
        // n = len(grid) - 2
        // s = sum(grid), s2 = sum(grid^2)
        // 设x重复，y缺失
        // [1, 2, ..., n^2, x, y]
        // s - x + y = n(n + 1) / 2
        // s2 - x^2 + y^2 = n(n + 1)(2n + 1) / 6

        // x - y = s - n(n + 1) / 2 = a
        // x^2 - y^2 = s2 - n(n + 1)(2n + 1) / 6 = b
        // x + y = b / a
        // x = (b / a + a) / 2, y = (b / a - a) / 2
        var n = grid.length;
        n *= n;
        var sum = 0;
        var sum2 = 0;
        for (var row : grid) {
            for (var item : row) {
                sum += item;
                sum2 += item * item;
            }
        }
        var a = sum - ((n * (n + 1)) >>> 1);
        // 当n过大时中间结果会溢出！！！
        var b = sum2 - (int) ((long) n * (n + 1) * (2 * (long) n + 1) / 6);
        return new int[]{
                (b / a + a) >>> 1,
                (b / a - a) >>> 1,
        };
    }
}
