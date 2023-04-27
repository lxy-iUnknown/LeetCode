package com.lxy.leetcode.simulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CreateTargetArrayTest {
    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{0, 1, 2, 3, 4},
                        new int[]{0, 1, 2, 2, 1},
                        new int[]{0, 4, 1, 3, 2}),
                Arguments.of(new int[]{1, 2, 3, 4, 0},
                        new int[]{0, 1, 2, 3, 0},
                        new int[]{0, 1, 2, 3, 4}),
                Arguments.of(new int[]{1},
                        new int[]{0},
                        new int[]{1})
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void createTargetArrayTest(int[] numbers, int[] indices, int[] expected) {
        Assertions.assertArrayEquals(expected, CreateTargetArray.createTargetArray(numbers, indices));
    }
}
