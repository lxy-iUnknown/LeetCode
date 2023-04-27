package com.lxy.leetcode.simulation;

public class MinMaxGame {
    public static int minMaxGame(int[] numbers) {
        int count = numbers.length / 2;
        int stride = 2, delta = 1;
        while (count >= 1) {
            for (int i = 0; i < count; i++) {
                int firstIndex = i * stride;
                int lastIndex = firstIndex + delta;
                if ((i % 2) == 0) {
                    numbers[firstIndex] = Math.min(numbers[firstIndex], numbers[lastIndex]);
                } else {
                    numbers[firstIndex] = Math.max(numbers[firstIndex], numbers[lastIndex]);
                }
            }
            stride *= 2;
            delta *= 2;
            count /= 2;
        }
        return numbers[0];
    }

    private static int minMaxGameRecursive(int[] numbers, int start, int end) {
        // Precondition: length is a power of two
        int length = end - start;
        // This is equivalent to length == 1
        if ((length & 1) != 0) {
            // Finish recursion
            return numbers[start];
        }
        int mid = (start + end) / 2;
        // This is equivalent to ((start / length) % 2) == 0
        if ((start & length) == 0) {
            return Math.min(
                    minMaxGameRecursive(numbers, start, mid),
                    minMaxGameRecursive(numbers, mid, end));
        }
        return Math.max(
                minMaxGameRecursive(numbers, start, mid),
                minMaxGameRecursive(numbers, mid, end));
    }

    public static int minMaxGameRecursive(int[] numbers) {
        return minMaxGameRecursive(numbers, 0, numbers.length);
    }
}
