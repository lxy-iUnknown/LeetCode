package com.lxy.leetcode.array2d;

import java.util.Arrays;
import java.util.HashSet;

/**
 * <a href="https://leetcode.cn/problems/zero-matrix-lcci">零矩阵</a>
 */
public class SetZeros {
    private static void clearRow(int[][] matrix, int r, int n) {
        Arrays.fill(matrix[r], 0, n, 0);
    }

    private static void clearColumn(int[][] matrix, int c, int m) {
        for (int r = 0; r < m; r++) {
            matrix[r][c] = 0;
        }
    }

    public static void setZeros(int[][] matrix) {
        final int DEFAULT_CAPACITY = 10;

        int m = matrix.length;
        if (m == 0) {
            return;
        }
        int n = matrix[0].length;
        HashSet<Integer> rows = new HashSet<>(DEFAULT_CAPACITY);
        HashSet<Integer> columns = new HashSet<>(DEFAULT_CAPACITY);
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (matrix[r][c] == 0) {
                    rows.add(r);
                    columns.add(c);
                }
            }
        }
        for (int r : rows) {
            clearRow(matrix, r, n);
        }
        for (int c : columns) {
            clearColumn(matrix, c, m);
        }
    }

    public static void setZerosTag(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return;
        }
        int n = matrix[0].length;
        boolean[] rows = new boolean[m];
        boolean[] columns = new boolean[n];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (matrix[r][c] == 0) {
                    rows[r] = true;
                    columns[c] = true;
                }
            }
        }
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (rows[r] || columns[c]) {
                    matrix[r][c] = 0;
                }
            }
        }
    }


    public static void setZerosOptimized(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return;
        }
        int n = matrix[0].length;
        boolean firstRowContainsZero = false, firstColumnContainsZero = false;
        // 遍历第一行，判断是否存在0
        for (int c = 0; c < n; c++) {
            if (matrix[0][c] == 0) {
                firstRowContainsZero = true;
                break;
            }
        }
        // 遍历第一列，判断是否存在0
        for (int r = 0; r < m; r++) {
            if (matrix[r][0] == 0) {
                firstColumnContainsZero = true;
                break;
            }
        }
        // 用第一行和第一列做标记
        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                if (matrix[r][c] == 0) {
                    // 将第一行和第一列相应位置标记为0
                    matrix[0][c] = 0;
                    matrix[r][0] = 0;
                }
            }
        }
        // 遍清除标记的行和列
        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                if (matrix[r][0] == 0 || matrix[0][c] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }
        // 如果第一行包含0则清除第一行
        if (firstRowContainsZero) {
            clearRow(matrix, 0, n);
        }
        // 如果第一列包含0则清除第一列
        if (firstColumnContainsZero) {
            clearColumn(matrix, 0, m);
        }
    }
}
