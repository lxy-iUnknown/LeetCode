package com.lxy.leetcode.simulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MinMaxGameTest {
    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 5, 2, 4, 8, 2, 3}, 1),
                Arguments.of(new int[]{10, 3, 2, 2, 4, 8, 2, 3}, 2),
                Arguments.of(new int[]{10, 3, 2, 2}, 2),
                Arguments.of(new int[]{4, 8, 3, 2}, 3),
                Arguments.of(new int[]{3}, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void minMaxGameTest(int[] numbers, int expected) {
        Assertions.assertEquals(expected, MinMaxGame.minMaxGame(numbers));
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void minMaxGameRecursiveTest(int[] numbers, int expected) {
        Assertions.assertEquals(expected, MinMaxGame.minMaxGameRecursive(numbers));
    }
}
