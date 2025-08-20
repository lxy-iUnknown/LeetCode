package com.lxy.leetcode.simulation;

/**
 * <a href="https://leetcode.cn/problems/cells-with-odd-values-in-a-matrix/">奇数单元格的数量</a>
 */
public class OddCells {
    public static int oddCells(int m, int n, int[][] indices) {
        var rows = new int[m];
        var columns = new int[n];
        for (var index : indices) {
            rows[index[0]]++;
            columns[index[1]]++;
        }
        var count = 0;
        for (var row = 0; row < m; row++) {
            for (var column = 0; column < n; column++) {
                if (((rows[row] + columns[column]) % 2) != 0) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int flipAndChangeCounter(boolean[] isOdd, int index, int counter) {
        var oldValue = isOdd[index];
        isOdd[index] = !oldValue;
        return counter + (oldValue ? -1 : 1);
    }

    public static int oddCellsOptimized(int m, int n, int[][] indices) {
        var rowIsOdd = new boolean[m];
        var columnIsOdd = new boolean[n];
        var a = 0;
        var b = 0;
        for (var index : indices) {
            a = flipAndChangeCounter(rowIsOdd, index[0], a);
            b = flipAndChangeCounter(columnIsOdd, index[1], b);
        }
        return a * (n - b) + b * (m - a);
    }

    // Use long as bit vector(m, n <= 50)
    public static int oddCellsOptimizeSize(int m, int n, int[][] indices) {
        long rowIsOdd = 0;
        long columnIsOdd = 0;
        var a = 0;
        var b = 0;
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
