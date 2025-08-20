package com.lxy.leetcode.array1d;

/**
 * <a href="https://leetcode.cn/problems/merge-sorted-array/">合并两个有序数组</a>
 */
public class MergeSortedArray {

    public static void mergeSortedArray(int[] numbers1, int m, int[] numbers2, int n) {
        var totalLength = m + n;
        var numbers = new int[totalLength];
        var i = 0;
        var j = 0;
        var k = 0;
        while (i < m && j < n) {
            var number1 = numbers1[i];
            var number2 = numbers2[j];
            if (number1 < number2) {
                numbers[k++] = number1;
                i++;
            } else {
                numbers[k++] = number2;
                j++;
            }
        }
        while (i < m) {
            numbers[k++] = numbers1[i++];
        }
        while (j < n) {
            numbers[k++] = numbers2[j++];
        }
        System.arraycopy(numbers, 0, numbers1, 0, totalLength);
    }


    // 从后往前遍历
    public static void mergeSortedArrayOptimized(int[] numbers1, int m, int[] numbers2, int n) {
        var i = m - 1;
        var j = n - 1;
        var k = m + n;
        while (i >= 0 && j >= 0) {
            var number1 = numbers1[i];
            var number2 = numbers2[j];
            if (number1 > number2) {
                numbers1[--k] = number1;
                i--;
            } else {
                numbers1[--k] = number2;
                j--;
            }
        }
        while (i >= 0) {
            numbers1[--k] = numbers1[i--];
        }
        while (j >= 0) {
            numbers1[--k] = numbers2[j--];
        }
    }
}
