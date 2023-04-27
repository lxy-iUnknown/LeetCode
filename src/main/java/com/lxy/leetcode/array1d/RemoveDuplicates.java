package com.lxy.leetcode.array1d;

/**
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array">去除重复元素</a>
 */
public class RemoveDuplicates {
    public static int removeDuplicates(int[] numbers) {
        int value = numbers[0];
        int slow = 0, fast = 1;
        while (fast < numbers.length) {
            int number = numbers[fast];
            if (number != value) {
                numbers[++slow] = number;
                value = number;
            }
            fast++;
        }
        return slow + 1;
    }
}
