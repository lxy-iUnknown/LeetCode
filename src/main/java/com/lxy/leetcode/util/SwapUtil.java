package com.lxy.leetcode.util;

public class SwapUtil {
    public static void swap(char[] array, int a, int b) {
        var temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void swap(int[] array, int a, int b) {
        var temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static int swapIV(int[] array, int a, int b) {
        var temp = array[a];
        array[a] = b;
        return temp;
    }

    public static int swapVI(int[] array, int a, int b) {
        var temp = array[b];
        array[b] = a;
        return temp;
    }

    public static void swap(int[][] matrix, int r1, int c1, int r2, int c2) {
        var temp = matrix[r1][c1];
        matrix[r1][c1] = matrix[r2][c2];
        matrix[r2][c2] = temp;
    }
}
