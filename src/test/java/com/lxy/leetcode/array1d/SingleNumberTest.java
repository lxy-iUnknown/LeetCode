package com.lxy.leetcode.array1d;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class SingleNumberTest {
    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of(new int[]{1}, 1),
            Arguments.of(new int[]{2, 2, 1}, 1),
            Arguments.of(new int[]{4, 1, 2, 1, 2}, 4),
            Arguments.of(new int[]{1, 2, 4, 1, 2}, 4),
            Arguments.of(new int[]{2, 1, 3, 2, 5, 4, 3, 1, 4}, 5),
            Arguments.of(new int[]{8, 1, 5, 1, 7, 8, 5}, 7),
            Arguments.of(new int[]{5, 4, 6, 1, 6, 5, 4}, 1),
            Arguments.of(new int[]{5, 9, 1, 1, 5, 9, 7}, 7),
            Arguments.of(new int[]{0, 2, 0, 5, 1, 4, 1, 2, 3, 4, 3}, 5),
            Arguments.of(new int[]{6, 7, 6, 8, 7, 8, 4}, 4),
            Arguments.of(new int[]{8, 7, 1, 7, 9, 3, 9, 8, 7, 7, 1}, 3),
            Arguments.of(new int[]{4, 9, 9, 10, 6, 4, 6, 10, 9, 8, 9}, 8),
            Arguments.of(new int[]{5, 8, 1, 5, 8, 7, 6, 1, 6}, 7),
            Arguments.of(new int[]{3, 8, 1, 8, 2, 3, 1}, 2),
            Arguments.of(new int[]{5, 9, 4, 6, 9, 8, 5, 8, 6}, 4),
            Arguments.of(new int[]{2, 7, 3, 4, 8, 8, 4, 7, 2}, 3),
            Arguments.of(new int[]{10, 8, 5, 8, 2, 10, 0, 5, 9, 0, 9}, 2),
            Arguments.of(new int[]{6, 5, 5, 7, 10, 6, 7}, 10)
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void singleNumberTest(int[] numbers, int expected) {
        Assertions.assertEquals(expected, SingleNumber.singleNumber(numbers));
    }

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void singleNumberOptimizedTest(int[] numbers, int expected) {
        Assertions.assertEquals(expected, SingleNumber.singleNumberOptimized(numbers));
    }
}
