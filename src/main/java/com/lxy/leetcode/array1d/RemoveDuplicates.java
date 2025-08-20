package com.lxy.leetcode.array1d;

/**
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array/">去除重复元素</a>
 */
public class RemoveDuplicates {
    public static int removeDuplicates(int[] numbers) {
        var value = numbers[0];
        var slow = 0;
        var fast = 1;
        while (fast < numbers.length) {
            var number = numbers[fast];
            if (number != value) {
                numbers[++slow] = number;
                value = number;
            }
            fast++;
        }
        return slow + 1;
    }
}
