package com.lxy.leetcode.simulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MinimumOperationsTest {
    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{7, 3, 1, 0, 2, 10, 0}, 5),
                Arguments.of(new int[]{0, 3, 10, 3, 3, 3, 1}, 3),
                Arguments.of(new int[]{1, 5, 0, 3, 5}, 3),
                Arguments.of(new int[]{0}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void minimumOperationTest(int[] numbers, int expected) {
        Assertions.assertEquals(expected, MinimumOperations.minimumOperations(numbers));
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void minimumOperationOptimizedTest(int[] numbers, int expected) {
        Assertions.assertEquals(expected, MinimumOperations.minimumOperationsOptimized(numbers));
    }
}
