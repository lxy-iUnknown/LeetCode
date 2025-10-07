package com.lxy.leetcode.util;

public class MathUtil {
    public static boolean isPowerOfTwo(int n) {
        return (n & n - 1) == 0 && n > 0;
    }

    public static boolean isPowerOfTwo(long n) {
        return (n & n - 1) == 0 && n > 0;
    }

    public static int gcd(int a, int b) {
        if ((a | b) == 0) {
            throw new IllegalArgumentException("a和b不能同时为0");
        }
        if (b > a) {
            return gcd(b, a);
        }
        while (b != 0) {
            var p = a % b;
            a = b;
            b = p;
        }
        return a;
    }

    public static long gcd(long a, long b) {
        if ((a | b) == 0) {
            throw new IllegalArgumentException("a和b不能同时为0");
        }
        if (b > a) {
            return gcd(b, a);
        }
        while (b != 0) {
            var p = a % b;
            a = b;
            b = p;
        }
        return a;
    }
}
