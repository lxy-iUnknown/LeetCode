package com.lxy.leetcode.util;

public class MathUtil {
    public static boolean isPowerOfTwo(int n) {
        return (n & n - 1) == 0 && n > 0;
    }

    public static boolean isPowerOfTwo(long n) {
        return (n & n - 1) == 0 && n > 0;
    }
}
