package com.lxy.leetcode.array2d;

public class FindDiagonalOrder {
    public static int[] findDiagonalOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return new int[0];
        }
        int n = matrix[0].length;
        int[] result = new int[m * n];
        int index = 0;
        int count = m + n - 2;
        for (int i = 0; i <= count; i++) {
            int minRow, maxRow;
            if (m >= n) {
                if (i < n - 1) {
                    minRow = 0;
                    maxRow = i;
                } else {
                    minRow = i - n + 1;
                    maxRow = i < m - 1 ? i : m - 1;
                }
            } else {
                if (i < n - 1) {
                    minRow = 0;
                    maxRow = i < m - 1 ? i : m - 1;
                } else {
                    minRow = i - n + 1;
                    maxRow = m - 1;
                }
            }
            if ((i % 2) == 0) {
                for (int r = maxRow; r >= minRow; r--) {
                    int c = i - r;
                    result[index++] = matrix[r][c];
                }
            } else {
                for (int r = minRow; r <= maxRow; r++) {
                    int c = i - r;
                    result[index++] = matrix[r][c];
                }
            }
        }
        return result;
    }
}
