package com.lxy.leetcode.simulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class TransposeTest {
    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of(new int[][]{
                    new int[]{1, 2, 3},
                    new int[]{4, 5, 6},
                    new int[]{7, 8, 9}
            }, new int[][]{
                    new int[]{1, 4, 7},
                    new int[]{2, 5, 8},
                    new int[]{3, 6, 9}
            }),
            Arguments.of(new int[][]{
                    new int[]{1, 2, 3},
                    new int[]{4, 5, 6},
                    new int[]{7, 8, 9},
                    new int[]{10, 11, 12},
                    new int[]{13, 14, 15}
            }, new int[][]{
                    new int[]{1, 4, 7, 10, 13},
                    new int[]{2, 5, 8, 11, 14},
                    new int[]{3, 6, 9, 12, 15}
            }),
            Arguments.of(new int[][]{
                    new int[]{1, 2, 3, 4, 5, 6},
                    new int[]{7, 8, 9, 10, 11, 12},
                    new int[]{13, 14, 15, 16, 17, 18}
            }, new int[][]{
                    new int[]{1, 7, 13},
                    new int[]{2, 8, 14},
                    new int[]{3, 9, 15},
                    new int[]{4, 10, 16},
                    new int[]{5, 11, 17},
                    new int[]{6, 12, 18}
            })
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void transposeTest(int[][] matrix, int[][] expected) {
        Assertions.assertArrayEquals(expected, Transpose.transpose(matrix));
    }
}
