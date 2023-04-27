package com.lxy.leetcode.simulation;

/**
 * <a href="https://leetcode.cn/problems/difference-between-ones-and-zeros-in-row-and-column/">行和列中一和零的差值</a>
 */
public class OneMinusZeros {
    public static int[][] onesMinusZeros(int[][] grid) {
        // diff = o_i + o_j - z_i - z_j
        //      = o_i + o_j - (n - o_i) - (m - o_j)
        //      = 2(o_i + o_j) - (m + n)
        int m = grid.length;
        int n = grid[0].length;
        int[] onesRow = new int[m];
        int[] onesColumn = new int[n];
        int row, column;
        // Calculate number of ones in each row and column
        for (row = 0; row < m; row++) {
            for (column = 0; column < n; column++) {
                int value = grid[row][column];
                onesRow[row] += value;
                onesColumn[column] += value;
            }
        }
        // Calculate differences of each grid item
        int sum = m + n;
        for (row = 0; row < m; row++) {
            for (column = 0; column < n; column++) {
                grid[row][column] = 2 * (onesRow[row] + onesColumn[column]) - sum;
            }
        }
        return grid;
    }

    // 1变1，0变-1，即可消去成对的1和0，获得1的个数减0的个数之差
    public static int[][] onesMinusZerosOptimized(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] onesRow = new int[m];
        int[] onesColumn = new int[n];
        int row, column;
        for (row = 0; row < m; row++) {
            for (column = 0; column < n; column++) {
                int value = grid[row][column];
                onesRow[row] += 2 * value - 1;
                onesColumn[column] += 2 * value - 1;
            }
        }
        for (row = 0; row < m; row++) {
            for (column = 0; column < n; column++) {
                grid[row][column] = onesRow[row] + onesColumn[column];
            }
        }
        return grid;
    }
}