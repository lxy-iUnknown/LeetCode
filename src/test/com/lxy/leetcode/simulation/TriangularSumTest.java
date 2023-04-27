package com.lxy.leetcode.simulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class TriangularSumTest {
    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 8),
                Arguments.of(new int[]{5}, 5),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7}, 6),
                Arguments.of(new int[]{4, 3, 7, 1, 5, 0, 2, 8}, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void triangularSumTest(int[] numbers, int expected) {
        Assertions.assertEquals(expected, TriangularSum.triangularSum(numbers));
    }
}
