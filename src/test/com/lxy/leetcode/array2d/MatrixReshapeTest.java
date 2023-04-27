package com.lxy.leetcode.array2d;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MatrixReshapeTest {
    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[][]{
                        new int[]{1, 2, 3, 4, 5},
                        new int[]{6, 7, 8, 9, 10}
                }, 1, 10, new int[][]{
                        new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                }),
                Arguments.of(new int[][]{
                        new int[]{1, 2, 3, 4, 5},
                        new int[]{6, 7, 8, 9, 10}
                }, 10, 1, new int[][]{
                        new int[]{1},
                        new int[]{2},
                        new int[]{3},
                        new int[]{4},
                        new int[]{5},
                        new int[]{6},
                        new int[]{7},
                        new int[]{8},
                        new int[]{9},
                        new int[]{10},
                }),
                Arguments.of(new int[][]{
                        new int[]{1, 2, 3, 4, 5, 6},
                        new int[]{7, 8, 9, 10, 11, 12}
                }, 4, 3, new int[][]{
                        new int[]{1, 2, 3},
                        new int[]{4, 5, 6},
                        new int[]{7, 8, 9},
                        new int[]{10, 11, 12}
                }),
                Arguments.of(new int[][]{
                        new int[]{1, 2, 3, 4, 5, 6},
                        new int[]{7, 8, 9, 10, 11, 12}
                }, 3, 4, new int[][]{
                        new int[]{1, 2, 3, 4},
                        new int[]{5, 6, 7, 8},
                        new int[]{9, 10, 11, 12}
                }),
                Arguments.of(new int[][]{
                        new int[]{1, 2, 3, 4, 5, 6, 7, 8},
                        new int[]{9, 10, 11, 12, 13, 14, 15, 16}
                }, 4, 4, new int[][]{
                        new int[]{1, 2, 3, 4},
                        new int[]{5, 6, 7, 8},
                        new int[]{9, 10, 11, 12},
                        new int[]{13, 14, 15, 16},
                }),
                Arguments.of(new int[][]{
                        new int[]{1, 2, 3, 4, 5},
                        new int[]{6, 7, 8, 9, 10}
                }, 5, 2, new int[][]{
                        new int[]{1, 2},
                        new int[]{3, 4},
                        new int[]{5, 6},
                        new int[]{7, 8},
                        new int[]{9, 10}
                }),
                Arguments.of(new int[][]{
                        new int[]{1, 2, 3, 4},
                        new int[]{5, 6, 7, 8},
                        new int[]{9, 10, 11, 12},
                        new int[]{13, 14, 15, 16}
                }, 2, 8, new int[][]{
                        new int[]{1, 2, 3, 4, 5, 6, 7, 8},
                        new int[]{9, 10, 11, 12, 13, 14, 15, 16}
                }),
                Arguments.of(new int[][]{
                        new int[]{1, 2, 3, 4},
                        new int[]{5, 6, 7, 8},
                        new int[]{9, 10, 11, 12},
                        new int[]{13, 14, 15, 16}
                }, 8, 2, new int[][]{
                        new int[]{1, 2},
                        new int[]{3, 4},
                        new int[]{5, 6},
                        new int[]{7, 8},
                        new int[]{9, 10},
                        new int[]{11, 12},
                        new int[]{13, 14},
                        new int[]{15, 16},
                }),
                Arguments.of(new int[][]{
                        new int[]{1, 2, 3, 4, 5},
                        new int[]{6, 7, 8, 9, 10}
                }, 3, 4, null),
                Arguments.of(new int[][]{
                        new int[]{1, 2, 3, 4, 5, 6},
                        new int[]{7, 8, 9, 10, 11, 12}
                }, 4, 5, null),
                Arguments.of(new int[][]{
                        new int[]{1, 2, 3, 4, 5},
                        new int[]{6, 7, 8, 9, 10}
                }, 1, 9, null)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void matrixReshapeTest(int[][] matrix, int r, int c, int[][] reshaped) {
        int[][] actual = MatrixReshape.matrixReshape(matrix, r, c);
        if (matrix.length * matrix[0].length != r * c) {
            Assertions.assertEquals(matrix, actual);
        } else {
            Assertions.assertArrayEquals(reshaped, actual);
        }
    }
}
