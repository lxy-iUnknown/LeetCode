package com.lxy.leetcode.array2d;

public class MatrixReshape {

    public static int[][] matrixReshape(int[][] matrix, int r, int c) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (m * n != r * c) {
            return matrix;
        }
        int[][] result = new int[r][];
        for (int row = 0; row < r; row++) {
            int[] rows = new int[c];
            for (int column = 0; column < c; column++) {
                int index = row * c + column;
                int oldRow = index / n;
                int oldColumn = index - oldRow * n;
                rows[column] = matrix[oldRow][oldColumn];
            }
            result[row] = rows;
        }
        return result;
    }
}
