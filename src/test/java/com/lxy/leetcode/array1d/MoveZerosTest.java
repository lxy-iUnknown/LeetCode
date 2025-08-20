package com.lxy.leetcode.array1d;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class MoveZerosTest {

    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of(
                    new int[]{0, 1, 0, 3, 12},
                    new int[]{1, 3, 12, 0, 0}
            ), Arguments.of(
            new int[]{0, 7, 2, 0, 0, 4, 8, 1, 9, 0},
            new int[]{7, 2, 4, 8, 1, 9, 0, 0, 0, 0}
    ), Arguments.of(
            new int[]{5, 7, 3, 1},
            new int[]{5, 7, 3, 1}
    ), Arguments.of(
            new int[]{0, 10, 4, 9, 0, 0, 0, 6, 7, 2, 0, 0, 4, 8, 1, 9, 0, 3, 5},
            new int[]{10, 4, 9, 6, 7, 2, 4, 8, 1, 9, 3, 5, 0, 0, 0, 0, 0, 0, 0})
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void moveZerosTest(int[] input, int[] expected) {
        MoveZeros.moveZeros(input);
        Assertions.assertArrayEquals(expected, input);
    }

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void moveZerosInplaceTest(int[] input, int[] expected) {
        MoveZeros.moveZerosInplace(input);
        Assertions.assertArrayEquals(expected, input);
    }
}
