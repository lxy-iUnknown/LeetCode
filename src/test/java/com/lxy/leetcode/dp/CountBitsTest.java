package com.lxy.leetcode.dp;

import com.lxy.leetcode.util.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.FieldSource;

import java.util.List;

public class CountBitsTest {
    private static final int COUNT = 100;
    public static final List<Integer> ARGUMENTS = TestUtil.generateRangeArray(0, COUNT);

    private static int[] countBits(int n) {
        var result = new int[n + 1];
        for (var i = 0; i <= n; i++) {
            result[i] = Integer.bitCount(i);
        }
        return result;
    }

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void countBitsTest(int n) {
        Assertions.assertArrayEquals(countBits(n), CountBits.countBits(n));
    }

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void countBitsOptimizedTest(int n) {
        Assertions.assertArrayEquals(countBits(n), CountBits.countBitsOptimized(n));
    }
}
