package com.lxy.leetcode.array2d;

public class MatrixReshape {

    public static int[][] matrixReshape(int[][] matrix, int r, int c) {
        var m = matrix.length;
        var n = matrix[0].length;
        if (m * n != r * c) {
            return matrix;
        }
        var result = new int[r][];
        for (var row = 0; row < r; row++) {
            var rows = new int[c];
            for (var column = 0; column < c; column++) {
                var index = row * c + column;
                var oldRow = index / n;
                var oldColumn = index - oldRow * n;
                rows[column] = matrix[oldRow][oldColumn];
            }
            result[row] = rows;
        }
        return result;
    }
}
