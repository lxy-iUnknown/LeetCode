package com.lxy.leetcode.simulation;

/**
 * <a href="https://leetcode.cn/problems/create-target-array-in-the-given-order/">按既定顺序创建数组</a>
 */
public class CreateTargetArray {

    public static int[] createTargetArray(int[] numbers, int[] indices) {
        int length = numbers.length;
        int[] array = new int[length];
        int count = 0;
        for (int i = 0; i < length; i++) {
            int index = indices[i];
            System.arraycopy(array, index, array, index + 1, count - index);
            array[index] = numbers[i];
            count++;
        }
        return array;
    }
}
