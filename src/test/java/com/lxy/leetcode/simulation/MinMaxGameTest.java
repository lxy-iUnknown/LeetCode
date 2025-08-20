package com.lxy.leetcode.simulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class MinMaxGameTest {
    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of(new int[]{1, 3, 5, 2, 4, 8, 2, 3}, 1),
            Arguments.of(new int[]{10, 3, 2, 2, 4, 8, 2, 3}, 2),
            Arguments.of(new int[]{10, 3, 2, 2}, 2),
            Arguments.of(new int[]{4, 8, 3, 2}, 3),
            Arguments.of(new int[]{3}, 3)
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void minMaxGameTest(int[] numbers, int expected) {
        Assertions.assertEquals(expected, MinMaxGame.minMaxGame(numbers));
    }

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void minMaxGameRecursiveTest(int[] numbers, int expected) {
        Assertions.assertEquals(expected, MinMaxGame.minMaxGameRecursive(numbers));
    }
}
