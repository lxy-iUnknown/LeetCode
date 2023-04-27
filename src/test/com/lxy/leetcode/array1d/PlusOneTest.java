package com.lxy.leetcode.array1d;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class PlusOneTest {

    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{0}, new int[]{1}),
                Arguments.of(new int[]{1, 2, 3}, new int[]{1, 2, 4}),
                Arguments.of(new int[]{4, 3, 2, 1}, new int[]{4, 3, 2, 2}),
                Arguments.of(new int[]{9}, new int[]{1, 0}),
                Arguments.of(new int[]{9, 9, 9}, new int[]{1, 0, 0, 0}),
                Arguments.of(new int[]{9, 9, 9, 9}, new int[]{1, 0, 0, 0, 0}),
                Arguments.of(new int[]{5, 7, 4, 9}, new int[]{5, 7, 5, 0}),
                Arguments.of(new int[]{6, 7, 4, 8, 9, 9, 9, 9}, new int[]{6, 7, 4, 9, 0, 0, 0, 0}),
                Arguments.of(new int[]{9, 9, 9, 9, 9, 9, 9, 9}, new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0})
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void plusOneTest(int[] digits, int[] expected) {
        Assertions.assertArrayEquals(expected, PlusOne.plusOne(digits));
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void plusOneOptimizedTest(int[] digits, int[] expected) {
        Assertions.assertArrayEquals(expected, PlusOne.plusOneOptimized(digits));
    }
}
