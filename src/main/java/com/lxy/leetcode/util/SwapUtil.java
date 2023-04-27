package com.lxy.leetcode.util;

public class SwapUtil {

    public static void swap(int[] numbers, int a, int b) {
        swapII(numbers, a, b);
    }

    public static void swapII(int[] numbers, int a, int b) {
        int temp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = temp;
    }

    public static int swapIV(int[] numbers, int a, int b) {
        int temp = numbers[a];
        numbers[a] = b;
        return temp;
    }

    public static int swapVI(int[] numbers, int a, int b) {
        int temp = numbers[b];
        numbers[b] = a;
        return temp;
    }
}
