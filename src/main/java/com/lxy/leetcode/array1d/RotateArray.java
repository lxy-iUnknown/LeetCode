package com.lxy.leetcode.array1d;

import com.lxy.leetcode.util.SwapUtil;

/**
 * <a href="https://leetcode.cn/problems/rotate-array">数组旋转</a>
 */
public class RotateArray {

    private static void reverse(int[] numbers, int start, int end) {
        while (start < end) {
            SwapUtil.swapII(numbers, start, end);
            start++;
            end--;
        }
    }

    public static void rotate(int[] numbers, int k) {
        int length = numbers.length;
        k %= length;
        int[] temp = new int[length];
        int i;
        int restLength = length - k;
        for (i = 0; i < length; i++) {
            temp[i] = numbers[(i + restLength) % length];
        }
        for (i = 0; i < length; i++) {
            numbers[i] = temp[i];
        }
    }

    /**
     * <a href="https://leetcode.cn/problems/rotate-array/solutions/1113807/c-dong-hua-yan-shi-189-lun-zhuan-shu-zu-kttsg/">数组旋转动画演示</a>
     */
    public static void rotateCircularReplace(int[] numbers, int k) {
        int swapCount = 0;
        int length = numbers.length;
        k %= length;
        for (int i = 0; i < length; i++) {
            int current = i;
            if (swapCount >= length) {
                break;
            }
            int last = numbers[i];
            do {
                int next = (current + k) % length;
                last = SwapUtil.swapIV(numbers, next, last);
                swapCount++;
                current = next;
            } while (current != i);
        }
    }

    public static void rotateReverse(int[] numbers, int k) {
        // |===========|-----| (k = 4)
        // 0 1 2 3 4 5 6 7 8 9 original
        // 9 8 7 6 5 4 3 2 1 0 reverse all
        // |-----|             reverse start
        // 6 7 8 9 5 4 3 2 1 0
        //         |=========| reverse end
        // 6 7 8 9 0 1 2 3 4 5

        int length = numbers.length;
        k %= length;
        length--;
        reverse(numbers, 0, length);
        reverse(numbers, 0, k - 1);
        reverse(numbers, k, length);
    }
}
