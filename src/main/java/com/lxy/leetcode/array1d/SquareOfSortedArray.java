package com.lxy.leetcode.array1d;

public class SquareOfSortedArray {
    private static int firstNonNegativeIndex(int[] numbers, int length) {
        // Simple binary search
        int low = 0, high = length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int midValue = numbers[mid];
            if (midValue < 0) {
                low = mid + 1;
            } else if (midValue > 0) {
                high = mid - 1;
            } else {
                // Handle repeated element
                do {
                    mid--;
                } while (mid >= 0 && numbers[mid] == 0);
                return mid + 1;
            }
        }
        // Key not found, return insertion point
        return low;
    }

    private static int firstNonNegativeIndexLinearSearch(int[] numbers, int length) {
        for (int i = 0; i < length; i++) {
            if (numbers[i] >= 0) {
                return i;
            }
        }
        return length;
    }

    private static int[] sortedSquares(int[] numbers, int length, int index) {
        int[] result = new int[length];
        int i = index - 1, j = index;
        int resultIndex = 0;
        int positive, negative;
        // Merge two "sorted" parts
        while (i >= 0 && j < length) {
            negative = numbers[i];
            positive = numbers[j];
            int value;
            if (-negative <= positive) {
                value = negative * negative;
                i--;
            } else {
                value = positive * positive;
                j++;
            }
            result[resultIndex++] = value;
        }
        while (i >= 0) {
            negative = numbers[i--];
            result[resultIndex++] = negative * negative;
        }
        while (j < length) {
            positive = numbers[j++];
            result[resultIndex++] = positive * positive;
        }
        return result;
    }

    public static int[] sortedSquares(int[] numbers) {
        int length = numbers.length;
        return sortedSquares(numbers, length, firstNonNegativeIndex(numbers, length));
    }

    public static int[] sortedSquaresLinearSearch(int[] numbers) {
        int length = numbers.length;
        return sortedSquares(numbers, length, firstNonNegativeIndexLinearSearch(numbers, length));
    }
}
