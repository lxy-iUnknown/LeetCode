package com.lxy.leetcode.array2d;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/convert-1d-array-into-2d-array/">将一维数组转变成二维数组</a>
 */
public class Construct2DArray {
    private static final int[][] EMPTY = new int[0][];

    public static int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) {
            return EMPTY;
        }
        int[][] array = new int[m][];
        for (int i = 0; i < m; i++) {
            int index = i * n;
            array[i] = Arrays.copyOfRange(original, index, index + n);
        }
        return array;
    }
}
