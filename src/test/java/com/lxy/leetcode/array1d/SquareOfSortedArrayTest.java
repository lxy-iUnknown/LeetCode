package com.lxy.leetcode.array1d;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class SquareOfSortedArrayTest {
    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of(
                    new int[]{-4, -1, 0, 3, 10},
                    new int[]{0, 1, 9, 16, 100}),
            Arguments.of(
                    new int[]{-7, -3, 2, 3, 11},
                    new int[]{4, 9, 9, 49, 121}),
            Arguments.of(
                    new int[]{-9, -5, -3, -1, 0, 0, 1, 2, 6, 10, 20},
                    new int[]{0, 0, 1, 1, 4, 9, 25, 36, 81, 100, 400}),
            Arguments.of(
                    new int[]{-10, -9, -6, -5, -3, -1},
                    new int[]{1, 9, 25, 36, 81, 100}),
            Arguments.of(
                    new int[]{0, 0, 1, 3, 5, 9},
                    new int[]{0, 0, 1, 9, 25, 81}),
            Arguments.of(
                    new int[]{-1, 0, 0, 0, 0, 0, 0, 0, 1},
                    new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1})
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void sortedSquaresTest(int[] numbers, int[] expected) {
        Assertions.assertArrayEquals(expected, SquareOfSortedArray.sortedSquares(numbers));
    }

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void sortedSquaresLinearSearchTest(int[] numbers, int[] expected) {
        Assertions.assertArrayEquals(expected, SquareOfSortedArray.sortedSquaresLinearSearch(numbers));
    }
}
