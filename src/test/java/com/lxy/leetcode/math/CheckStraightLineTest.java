package com.lxy.leetcode.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class CheckStraightLineTest {
    public static final Arguments[] ARGUMENTS = {
            Arguments.of(new int[][]{
                    new int[]{1, 1},
                    new int[]{9999, 9999},
                    new int[]{10000, 10000}
            }, true),
            Arguments.of(new int[][]{
                    new int[]{1, 2},
                    new int[]{3, 12},
                    new int[]{5, 22},
            }, true),
            Arguments.of(new int[][]{
                    new int[]{1, 2},
                    new int[]{3, 12},
                    new int[]{5, 22},
                    new int[]{7, 32},
                    new int[]{9, 42},
                    new int[]{11, 52}
            }, true),
            Arguments.of(new int[][]{
                    new int[]{1, 2},
                    new int[]{3, 4},
                    new int[]{5, 6},
                    new int[]{7, 8},
                    new int[]{9, 10},
                    new int[]{11, 13}
            }, false),
            Arguments.of(new int[][]{
                    new int[]{1, 1},
                    new int[]{3, 1},
                    new int[]{5, 1},
                    new int[]{7, 1},
                    new int[]{9, 1}
            }, true),
            Arguments.of(new int[][]{
                    new int[]{1, 1},
                    new int[]{1, 3},
                    new int[]{1, 5},
                    new int[]{1, 7},
                    new int[]{1, 9}
            }, true),
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void checkStraightLineTest(int[][] coordinates, boolean expected) {
        Assertions.assertEquals(expected, CheckStraightLine.checkStraightLine(coordinates));
    }
}
