package com.lxy.leetcode.array2d;

import com.lxy.leetcode.util.SwapUtil;

/**
 * <a href="https://leetcode.cn/problems/rotate-matrix-lcci/">矩阵旋转</a>
 */
public class RotateMatrix {
    private static void majorDiagonalTranspose(int[][] matrix) {
        var n = matrix.length;
        for (var r = 0; r < n - 1; r++) {
            for (var c = r + 1; c < n; c++) {
                SwapUtil.swap(matrix, r, c, c, r);
            }
        }
    }

    private static void minorDiagonalTranspose(int[][] matrix) {
        var maxIndex = matrix.length - 1;
        for (var r = 0; r < maxIndex; r++) {
            var newColumn = maxIndex - r;
            for (var c = 0; c < newColumn; c++) {
                SwapUtil.swap(matrix, r, c, maxIndex - c, newColumn);
            }
        }
    }

    private static void swapRows(int[][] matrix) {
        var start = 0;
        var end = matrix.length - 1;
        while (start < end) {
            var temp = matrix[start];
            matrix[start] = matrix[end];
            matrix[end] = temp;
            start++;
            end--;
        }
    }

    public static void rotateMatrix(int[][] matrix) {
        minorDiagonalTranspose(matrix);
        swapRows(matrix);
    }

    public static void rotateMatrix2(int[][] matrix) {
        swapRows(matrix);
        majorDiagonalTranspose(matrix);
    }

    /**
     * <a href="https://leetcode.cn/problems/rotate-matrix-lcci/solutions/190141/c-tu-jie-yuan-di-cao-zuo-ji-bai-shuang-bai-vv-by-t/">New algorithm</a>
     */
    public static void rotateMatrix3(int[][] matrix) {
        var n = matrix.length;
        if (n == 0) {
            return;
        }
        var maxRow = n / 2 - 1;
        var maxColumn = (n - 1) / 2;
        for (var r = 0; r <= maxRow; r++) {
            for (var c = 0; c <= maxColumn; c++) {
                var value1 = n - c - 1;
                var value2 = n - r - 1;
                SwapUtil.swap(matrix, r, c, value1, r);
                SwapUtil.swap(matrix, value1, r, value2, value1);
                SwapUtil.swap(matrix, value2, value1, c, value2);
            }
        }
    }
}
