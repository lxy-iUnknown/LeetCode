package com.lxy.leetcode.array2d;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SetZerosTest {

    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[][]{
                        new int[]{1, 1},
                        new int[]{1, 0},
                }, new int[][]{
                        new int[]{1, 0},
                        new int[]{0, 0},
                }), Arguments.of(new int[][]{
                        new int[]{1, 1, 1},
                        new int[]{1, 0, 1},
                }, new int[][]{
                        new int[]{1, 0, 1},
                        new int[]{0, 0, 0},
                }), Arguments.of(new int[][]{
                        new int[]{1, 1, 1},
                        new int[]{1, 0, 1},
                        new int[]{1, 1, 1}
                }, new int[][]{
                        new int[]{1, 0, 1},
                        new int[]{0, 0, 0},
                        new int[]{1, 0, 1}
                }), Arguments.of(new int[][]{
                        new int[]{0, 1, 2, 0},
                        new int[]{3, 4, 5, 2},
                        new int[]{1, 3, 1, 5},
                }, new int[][]{
                        new int[]{0, 0, 0, 0},
                        new int[]{0, 4, 5, 0},
                        new int[]{0, 3, 1, 0}
                }), Arguments.of(new int[][]{
                        new int[]{7, 1, 2, 5, 3},
                        new int[]{6, 0, 5, 2, 1},
                        new int[]{1, 3, 1, 0, 2},
                }, new int[][]{
                        new int[]{7, 0, 2, 0, 3},
                        new int[]{0, 0, 0, 0, 0},
                        new int[]{0, 0, 0, 0, 0},
                }), Arguments.of(new int[][]{
                        new int[]{7, 1, 2, 5, 8, 3},
                        new int[]{0, 4, 5, 0, 1, 6},
                        new int[]{1, 3, 1, 5, 2, 4},
                        new int[]{8, 3, 2, 0, 3, 1},
                }, new int[][]{
                        new int[]{0, 1, 2, 0, 8, 3},
                        new int[]{0, 0, 0, 0, 0, 0},
                        new int[]{0, 3, 1, 0, 2, 4},
                        new int[]{0, 0, 0, 0, 0, 0},
                }), Arguments.of(new int[][]{
                        new int[]{7, 1, 2, 5, 8, 3},
                        new int[]{3, 4, 5, 2, 1, 6},
                        new int[]{1, 3, 1, 5, 2, 4},
                        new int[]{8, 3, 0, 7, 3, 1},
                        new int[]{9, 2, 7, 3, 4, 6},
                        new int[]{1, 3, 8, 3, 0, 7},
                        new int[]{4, 2, 1, 1, 5, 4},
                }, new int[][]{
                        new int[]{7, 1, 0, 5, 0, 3},
                        new int[]{3, 4, 0, 2, 0, 6},
                        new int[]{1, 3, 0, 5, 0, 4},
                        new int[]{0, 0, 0, 0, 0, 0},
                        new int[]{9, 2, 0, 3, 0, 6},
                        new int[]{0, 0, 0, 0, 0, 0},
                        new int[]{4, 2, 0, 1, 0, 4},
                })
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void setZerosTest(int[][] matrix, int[][] expected) {
        SetZeros.setZeros(matrix);
        Assertions.assertArrayEquals(expected, matrix);
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void setZerosTagTest(int[][] matrix, int[][] expected) {
        SetZeros.setZerosTag(matrix);
        Assertions.assertArrayEquals(expected, matrix);
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void setZerosOptimizedTest(int[][] matrix, int[][] expected) {
        SetZeros.setZerosOptimized(matrix);
        Assertions.assertArrayEquals(expected, matrix);
    }
}
