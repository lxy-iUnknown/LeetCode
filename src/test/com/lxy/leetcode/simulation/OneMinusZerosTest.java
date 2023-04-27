package com.lxy.leetcode.simulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class OneMinusZerosTest {
    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[][]{
                                new int[]{0, 1, 1},
                                new int[]{1, 0, 1},
                                new int[]{0, 0, 1}},
                        new int[][]{
                                new int[]{0, 0, 4},
                                new int[]{0, 0, 4},
                                new int[]{-2, -2, 2}}),

                Arguments.of(new int[][]{
                                new int[]{1, 1, 1},
                                new int[]{1, 1, 1}},
                        new int[][]{
                                new int[]{5, 5, 5},
                                new int[]{5, 5, 5}})
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void oneMinusZerosTest(int[][] grid, int[][] expected) {
        Assertions.assertArrayEquals(expected, OneMinusZeros.onesMinusZeros(grid));
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void oneMinusZerosOptimizedTest(int[][] grid, int[][] expected) {
        Assertions.assertArrayEquals(expected, OneMinusZeros.onesMinusZerosOptimized(grid));
    }
}
