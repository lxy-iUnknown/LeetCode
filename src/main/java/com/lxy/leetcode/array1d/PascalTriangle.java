package com.lxy.leetcode.array1d;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/pascals-triangle/">杨辉三角</a>
 */
public class PascalTriangle {
    private static final List<Integer> PASCAL_1 = List.of(1);

    private static Integer[] generateFromPrevious(Integer[] array, int length) {
        var newArray = new Integer[length + 1];
        newArray[0] = 1;
        for (var i = 0; i < length - 1; i++) {
            newArray[i + 1] = array[i] + array[i + 1];
        }
        newArray[length] = 1;
        return newArray;
    }

    public static List<List<Integer>> pascalTriangle(int n) {
        var result = new ArrayList<List<Integer>>(n);
        result.add(PASCAL_1);
        var array = new Integer[]{1, 1};
        for (var i = 2; i <= n; i++) {
            // Use Arrays.asList instead of List.of,
            // because the latter will copy array contents to make list immutable,
            // which is not needed
            result.add(Arrays.asList(array));
            array = generateFromPrevious(array, i);
        }
        return result;
    }
}
