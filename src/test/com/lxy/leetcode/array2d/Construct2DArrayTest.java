package com.lxy.leetcode.array2d;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class Construct2DArrayTest {
    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 2, 3, 4},
                        2, 2,
                        new int[][]{
                                new int[]{1, 2},
                                new int[]{3, 4}
                        }),
                Arguments.of(
                        new int[]{1, 2, 3, 4},
                        1, 4,
                        new int[][]{
                                new int[]{1, 2, 3, 4},
                        }),
                Arguments.of(
                        new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                        2, 5,
                        new int[][]{
                                new int[]{1, 2, 3, 4, 5},
                                new int[]{6, 7, 8, 9, 10}
                        }),
                Arguments.of(
                        new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                        5, 2,
                        new int[][]{
                                new int[]{1, 2},
                                new int[]{3, 4},
                                new int[]{5, 6},
                                new int[]{7, 8},
                                new int[]{9, 10},
                        }),
                Arguments.of(
                        new int[]{1, 2, 3, 4, 5, 6},
                        2, 4,
                        new int[][]{}),
                Arguments.of(
                        new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                        2, 6,
                        new int[][]{}),
                Arguments.of(
                        new int[]{1, 2, 3, 4, 5, 6, 7},
                        3, 2,
                        new int[][]{})
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void construct2DArray(int[] original, int m, int n, int[][] expected) {
        Assertions.assertArrayEquals(expected, Construct2DArray.construct2DArray(original, m, n));
    }
}
