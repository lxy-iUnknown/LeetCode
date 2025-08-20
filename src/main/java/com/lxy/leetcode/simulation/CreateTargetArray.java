package com.lxy.leetcode.simulation;

/**
 * <a href="https://leetcode.cn/problems/create-target-array-in-the-given-order/">按既定顺序创建数组</a>
 */
public class CreateTargetArray {

    public static int[] createTargetArray(int[] numbers, int[] indices) {
        var length = numbers.length;
        var array = new int[length];
        var count = 0;
        for (var i = 0; i < length; i++) {
            var index = indices[i];
            System.arraycopy(array, index, array, index + 1, count - index);
            array[index] = numbers[i];
            count++;
        }
        return array;
    }
}
