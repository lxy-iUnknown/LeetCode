package com.lxy.leetcode.simulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class OddCellsTest {
    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(2, 3,
                        new int[][]{new int[]{0, 1}, new int[]{1, 1}}, 6),
                Arguments.of(2, 2,
                        new int[][]{new int[]{1, 1}, new int[]{0, 0}}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void oddCellsTest(int m, int n, int[][] indices, int expected) {
        Assertions.assertEquals(expected, OddCells.oddCells(m, n, indices));
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void oddCellsOptimizedTest(int m, int n, int[][] indices, int expected) {
        Assertions.assertEquals(expected, OddCells.oddCellsOptimized(m, n, indices));
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void oddCellsOptimizeSizeTest(int m, int n, int[][] indices, int expected) {
        Assertions.assertEquals(expected, OddCells.oddCellsOptimizeSize(m, n, indices));
    }
}
