package com.lxy.leetcode.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class PaintingPlanTest {
    private static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of(4, 13, 32),
            Arguments.of(2, 4, 1),
            Arguments.of(2, 2, 4),
            Arguments.of(3, 5, 9),
            Arguments.of(3, 4, 0),
            Arguments.of(5, 7, 0),
            Arguments.of(5, 20, 10),
            Arguments.of(3, 8, 9),
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void paintingPlanTest(int n, int k, int expected) {
        Assertions.assertEquals(expected, PaintingPlan.paintingPlan(n, k));
    }
}
