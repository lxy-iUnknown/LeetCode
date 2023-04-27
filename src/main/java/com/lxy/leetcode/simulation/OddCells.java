package com.lxy.leetcode.simulation;

/**
 * <a href="https://leetcode.cn/problems/cells-with-odd-values-in-a-matrix">奇数单元格的数量</a>
 */
public class OddCells {
    public static int oddCells(int m, int n, int[][] indices) {
        int[] rows = new int[m];
        int[] columns = new int[n];
        for (int[] index : indices) {
            rows[index[0]]++;
            columns[index[1]]++;
        }
        int count = 0;
        for (int row = 0; row < m; row++) {
            for (int column = 0; column < n; column++) {
                if (((rows[row] + columns[column]) % 2) != 0) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int flipAndChangeCounter(boolean[] isOdd, int index, int counter) {
        boolean oldValue = isOdd[index];
        isOdd[index] = !oldValue;
        return counter + (oldValue ? -1 : 1);
    }

    public static int oddCellsOptimized(int m, int n, int[][] indices) {
        boolean[] rowIsOdd = new boolean[m];
        boolean[] columnIsOdd = new boolean[n];
        int a = 0, b = 0;
        for (int[] index : indices) {
            a = flipAndChangeCounter(rowIsOdd, index[0], a);
            b = flipAndChangeCounter(columnIsOdd, index[1], b);
        }
        return a * (n - b) + b * (m - a);
    }

    // Use long as bit vector(m, n <= 50)
    public static int oddCellsOptimizeSize(int m, int n, int[][] indices) {
        long rowIsOdd = 0;
        long columnIsOdd = 0;
        int a = 0, b = 0;
        for (int[] index : indices) {
            long bitMask;

            // Compute bit mask
            bitMask = 1L << index[0];
            // Test if bit is set
            a += (rowIsOdd & bitMask) != 0 ? -1 : 1;
            // Flip bit
            rowIsOdd ^= bitMask;

            // Compute bit mask
            bitMask = 1L << index[1];
            // Test if bit is set
            b += (columnIsOdd & bitMask) != 0 ? -1 : 1;
            // Flip bit
            columnIsOdd ^= bitMask;
        }
        return a * (n - b) + b * (m - a);
    }
}
