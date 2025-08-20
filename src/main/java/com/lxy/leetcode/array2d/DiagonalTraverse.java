package com.lxy.leetcode.array2d;

/**
 * <a href="https://leetcode.cn/problems/diagonal-traverse/">对角线遍历</a>
 */
public class DiagonalTraverse {
    public static int[] diagonalTraverse(int[][] matrix) {
        var m = matrix.length;
        if (m == 0) {
            return new int[0];
        }
        var n = matrix[0].length;
        var result = new int[m * n];
        var index = 0;
        var count = m + n - 2;
        for (var i = 0; i <= count; i++) {
            int minRow, maxRow;
            if (m >= n) {
                if (i < n - 1) {
                    minRow = 0;
                    maxRow = i;
                } else {
                    minRow = i - n + 1;
                    maxRow = Math.min(i, m - 1);
                }
            } else {
                if (i < n - 1) {
                    minRow = 0;
                    maxRow = Math.min(i, m - 1);
                } else {
                    minRow = i - n + 1;
                    maxRow = m - 1;
                }
            }
            if ((i % 2) == 0) {
                for (var r = maxRow; r >= minRow; r--) {
                    var c = i - r;
                    result[index++] = matrix[r][c];
                }
            } else {
                for (var r = minRow; r <= maxRow; r++) {
                    var c = i - r;
                    result[index++] = matrix[r][c];
                }
            }
        }
        return result;
    }
}
