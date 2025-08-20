package com.lxy.leetcode.array1d;

/**
 * <a href="https://leetcode.cn/problems/search-insert-position/">查找插入位置</a>
 */
public class SearchInsert {
    private static int searchInsert(int[] array, int start, int end, int value) {
        if (start <= end) {
            var mid = (start + end) / 2;
            var midValue = array[mid];
            if (value == midValue) {
                return mid;
            } else if (value > midValue) {
                return searchInsert(array, mid + 1, end, value);
            } else {
                return searchInsert(array, start, mid - 1, value);
            }
        } else {
            return start;
        }
    }

    public static int searchInsert(int[] numbers, int target) {
        return searchInsert(numbers, 0, numbers.length - 1, target);
    }

    public static int searchInsertNonRecursive(int[] numbers, int target) {
        var start = 0;
        var end = numbers.length - 1;
        while (start <= end) {
            var mid = (start + end) / 2;
            var midValue = numbers[mid];
            if (target == midValue) {
                return mid;
            } else if (target > midValue) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}
