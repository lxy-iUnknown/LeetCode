package com.lxy.leetcode.array1d;

/**
 * <a href="https://leetcode.cn/problems/squares-of-a-sorted-array/">有序数组的平方</a>
 */
public class SquareOfSortedArray {
    private static int firstNonNegativeIndex(int[] numbers, int length) {
        // Simple binary search
        var low = 0;
        var high = length - 1;
        while (low <= high) {
            var mid = (low + high) / 2;
            var midValue = numbers[mid];
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
        for (var i = 0; i < length; i++) {
            if (numbers[i] >= 0) {
                return i;
            }
        }
        return length;
    }

    private static int[] sortedSquares(int[] numbers, int length, int index) {
        var result = new int[length];
        var i = index - 1;
        var j = index;
        var resultIndex = 0;
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
        var length = numbers.length;
        return sortedSquares(numbers, length, firstNonNegativeIndex(numbers, length));
    }

    public static int[] sortedSquaresLinearSearch(int[] numbers) {
        var length = numbers.length;
        return sortedSquares(numbers, length, firstNonNegativeIndexLinearSearch(numbers, length));
    }
}
