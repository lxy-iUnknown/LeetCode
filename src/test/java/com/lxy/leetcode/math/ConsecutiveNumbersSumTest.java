package com.lxy.leetcode.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class ConsecutiveNumbersSumTest {
    public static final Arguments[] ARGUMENTS = {
            Arguments.of(5, 2),
            Arguments.of(9, 3),
            Arguments.of(15, 4),
            Arguments.of(12345, 8),
            Arguments.of(12345678, 12),
            Arguments.of(456321048, 4),
            Arguments.of(100000000, 9),
            Arguments.of(1000000000, 10)
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void consecutiveNumbersSumTest(int n, int expected) {
        Assertions.assertEquals(expected, ConsecutiveNumbersSum.consecutiveNumbersSum(n));
    }

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void consecutiveNumbersSumOptimizedTest(int n, int expected) {
        Assertions.assertEquals(expected, ConsecutiveNumbersSum.consecutiveNumbersSumOptimized(n));
    }
}
