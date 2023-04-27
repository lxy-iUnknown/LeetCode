package com.lxy.leetcode.array1d;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.cn/problems/move-zeroes">移动零</a>
 */
public class MoveZeros {

    private static final Comparator<Integer> COMPARATOR = (o1, o2) -> {
        int leftUnboxed = o1;
        int rightUnboxed = o2;
        if ((leftUnboxed | rightUnboxed) == 0) {
            return 0;
        } else if (leftUnboxed == 0) {
            return 1;
        } else if (rightUnboxed == 0) {
            return -1;
        } else {
            return 0;
        }
    };

    public static void moveZeros(int[] numbers) {
        int length = numbers.length;
        Integer[] values = new Integer[length];
        for (int i = 0; i < length; i++) {
            values[i] = numbers[i];
        }
        Arrays.sort(values, 0, length, COMPARATOR);
        for (int i = 0; i < length; i++) {
            numbers[i] = values[i];
        }
    }

    public static void moveZerosInplace(int[] numbers) {
        int length = numbers.length;
        int i = 0, j = 0;
        while (i < length && j < length) {
            if (numbers[j] != 0) {
                numbers[i] = numbers[j];
                i++;
            }
            j++;
        }
        Arrays.fill(numbers, i, length, 0);
    }
}
