package com.lxy.leetcode.array1d;

import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/pascals-triangle-ii/">杨辉三角 II</a>
 */
public class PascalTriangle2 {

    public static List<Integer> pascalTriangle2(int n) {
        var array = new Integer[n + 1];
        array[0] = 1;
        for (var i = 1; i <= n; i++) {
            array[i] = 0; // Original value: null
            for (var j = i; j >= 1; j--) {
                array[j] = array[j] + array[j - 1];
            }
        }
        // Use Arrays.asList instead of List.of,
        // because the latter will copy array contents to make list immutable,
        // which is not needed
        return Arrays.asList(array);
    }

    // C(m, n) = C(m, n - 1) * (n - m + 1) / m
    public static List<Integer> pascalTriangle2Optimized(int n) {
        var array = new Integer[n + 1];
        array[0] = 1;
        for (var i = 1; i <= n; i++) {
            // Use long to avoid arithmetic overflow
            array[i] = (int) ((long) array[i - 1] * (n - i + 1) / i);
        }
        // Use Arrays.asList instead of List.of,
        // because the latter will copy array contents to make list immutable,
        // which is not needed
        return Arrays.asList(array);
    }
}
