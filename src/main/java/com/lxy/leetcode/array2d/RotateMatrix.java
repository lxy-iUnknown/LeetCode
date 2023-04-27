package com.lxy.leetcode.array2d;

/**
 * <a href="https://leetcode.cn/problems/rotate-matrix-lcci">矩阵旋转</a>
 */
public class RotateMatrix {
    private static void swap(int[][] matrix, int r1, int c1, int r2, int c2) {
        int temp = matrix[r1][c1];
        matrix[r1][c1] = matrix[r2][c2];
        matrix[r2][c2] = temp;
    }

    private static void majorDiagonalTranspose(int[][] matrix) {
        int n = matrix.length;
        for (int r = 0; r < n - 1; r++) {
            for (int c = r + 1; c < n; c++) {
                swap(matrix, r, c, c, r);
            }
        }
    }

    private static void minorDiagonalTranspose(int[][] matrix) {
        int maxIndex = matrix.length - 1;
        for (int r = 0; r < maxIndex; r++) {
            int newColumn = maxIndex - r;
            for (int c = 0; c < newColumn; c++) {
                swap(matrix, r, c, maxIndex - c, newColumn);
            }
        }
    }

    private static void swapRows(int[][] matrix) {
        int start = 0, end = matrix.length - 1;
        while (start < end) {
            int[] temp = matrix[start];
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
        int n = matrix.length;
        if (n == 0) {
            return;
        }
        int maxRow = n / 2 - 1;
        int maxColumn = (n - 1) / 2;
        for (int r = 0; r <= maxRow; r++) {
            for (int c = 0; c <= maxColumn; c++) {
                int value1 = n - c - 1;
                int value2 = n - r - 1;
                swap(matrix, r, c, value1, r);
                swap(matrix, value1, r, value2, value1);
                swap(matrix, value2, value1, c, value2);
            }
        }
    }
}
