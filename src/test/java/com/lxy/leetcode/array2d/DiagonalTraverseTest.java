package com.lxy.leetcode.array2d;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class DiagonalTraverseTest {

    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of(new int[][]{
                    new int[]{1, 2, 3},
                    new int[]{4, 5, 6},
                    new int[]{7, 8, 9}
            }, new int[]{1, 2, 4, 7, 5, 3, 6, 8, 9}),
            Arguments.of(new int[][]{
                    new int[]{5, 1, 9, 11},
                    new int[]{2, 4, 8, 10},
                    new int[]{13, 3, 6, 7},
                    new int[]{15, 14, 12, 16}
            }, new int[]{5, 1, 2, 13, 4, 9, 11, 8, 3, 15, 14, 6, 10, 7, 12, 16}),
            Arguments.of(new int[][]{
                    new int[]{7, 1, 2, 5, 3, 3},
                    new int[]{6, 0, 4, 2, 1, 8},
                    new int[]{1, 3, 1, 0, 2, 6},
            }, new int[]{7, 1, 6, 1, 0, 2, 5, 4, 3, 1, 2, 3, 3, 1, 0, 2, 8, 6}),
            Arguments.of(new int[][]{
                    new int[]{7, 6, 1},
                    new int[]{1, 0, 3},
                    new int[]{2, 4, 1},
                    new int[]{5, 2, 0},
                    new int[]{3, 1, 2},
                    new int[]{4, 3, 8},
                    new int[]{1, 7, 4},
            }, new int[]{7, 6, 1, 2, 0, 1, 3, 4, 5, 3, 2, 1, 0, 1, 4, 1, 3, 2, 8, 7, 4})
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void diagonalTraverse(int[][] matrix, int[] expected) {
        Assertions.assertArrayEquals(expected, DiagonalTraverse.diagonalTraverse(matrix));
    }
}
