package com.lxy.leetcode.simulation;

/**
 * <a href="https://leetcode.cn/problems/transpose-matrix/">转置矩阵</a>
 */
public class Transpose {
    public static int[][] transpose(int[][] matrix) {
        var m = matrix.length;
        var n = matrix[0].length;
        var newMatrix = new int[n][];
        for (var column = 0; column < n; column++) {
            var rows = new int[m];
            for (var row = 0; row < m; row++) {
                rows[row] = matrix[row][column];
            }
            newMatrix[column] = rows;
        }
        return newMatrix;
    }
}
