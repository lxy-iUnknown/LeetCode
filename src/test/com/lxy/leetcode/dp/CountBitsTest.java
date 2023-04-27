package com.lxy.leetcode.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;

public class CountBitsTest {
    private static final int COUNT = 100;

    private static int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            result[i] = Integer.bitCount(i);
        }
        return result;
    }

    public static IntStream arguments() {
        return IntStream.rangeClosed(0, COUNT);
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void countBitsTest(int n) {
        Assertions.assertArrayEquals(countBits(n), CountBits.countBits(n));
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void countBitsOptimizedTest(int n) {
        Assertions.assertArrayEquals(countBits(n), CountBits.countBitsOptimized(n));
    }
}
