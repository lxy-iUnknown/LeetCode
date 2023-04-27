package com.lxy.leetcode.array2d;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class RotateMatrixTest {

    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[][]{
                        new int[]{1, 2, 3},
                        new int[]{4, 5, 6},
                        new int[]{7, 8, 9}
                }, new int[][]{
                        new int[]{7, 4, 1},
                        new int[]{8, 5, 2},
                        new int[]{9, 6, 3}
                }), Arguments.of(new int[][]{
                        new int[]{5, 1, 9, 11},
                        new int[]{2, 4, 8, 10},
                        new int[]{13, 3, 6, 7},
                        new int[]{15, 14, 12, 16}
                }, new int[][]{
                        new int[]{15, 13, 2, 5},
                        new int[]{14, 3, 4, 1},
                        new int[]{12, 6, 8, 9},
                        new int[]{16, 7, 10, 11}})
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void rotateMatrixTest(int[][] matrix, int[][] expected) {
        RotateMatrix.rotateMatrix(matrix);
        Assertions.assertArrayEquals(expected, matrix);
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void rotateMatrixTest2(int[][] matrix, int[][] expected) {
        RotateMatrix.rotateMatrix2(matrix);
        Assertions.assertArrayEquals(expected, matrix);
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void rotateMatrixTest3(int[][] matrix, int[][] expected) {
        RotateMatrix.rotateMatrix3(matrix);
        Assertions.assertArrayEquals(expected, matrix);
    }
}
