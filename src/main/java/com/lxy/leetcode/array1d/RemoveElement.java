package com.lxy.leetcode.array1d;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/remove-element/">移除元素</a>
 */
public class RemoveElement {
    public static int removeElement(int[] numbers, int value) {
        int length = numbers.length;
        Arrays.sort(numbers, 0, length);
        int start = 0;
        while (start < length) {
            if (numbers[start] == value) {
                break;
            }
            start++;
        }
        int end = start;
        while (end < length) {
            if (numbers[end] != value) {
                break;
            }
            end++;
        }
        System.arraycopy(numbers, end, numbers, start, length - end);
        return length - (end - start);
    }

    public static int removeElementOptimized(int[] numbers, int value) {
        int slow = 0, fast = 0;
        int length = numbers.length;
        while (fast < length) {
            int number = numbers[fast++];
            if (number != value) {
                numbers[slow++] = number;
            }
        }
        return slow;
    }
}
