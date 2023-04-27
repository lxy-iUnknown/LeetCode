package com.lxy.leetcode.simulation;

public class Transpose {
    public static int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] newMatrix = new int[n][];
        for (int column = 0; column < n; column++) {
            int[] rows = new int[m];
            for (int row = 0; row < m; row++) {
                rows[row] = matrix[row][column];
            }
            newMatrix[column] = rows;
        }
        return newMatrix;
    }
}
