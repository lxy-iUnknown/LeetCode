package com.lxy.leetcode.simulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class FractionTest {
    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of(new int[]{3, 2, 0, 2}, new int[]{13, 4}),
            Arguments.of(new int[]{3, 2, 5, 4, 7}, new int[]{1151, 333}),
            Arguments.of(new int[]{3, 3, 1, 2, 1, 2}, new int[]{134, 41}),
            Arguments.of(new int[]{0, 1, 1, 2, 2, 3, 3}, new int[]{79, 135}),
            Arguments.of(new int[]{3, 1, 3}, new int[]{15, 4}),
            Arguments.of(new int[]{0, 0, 3}, new int[]{3, 1})
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void fractionTest(int[] cont, int[] expected) {
        Assertions.assertArrayEquals(expected, Fraction.fraction(cont));
    }

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void fractionOptimizedTest(int[] cont, int[] expected) {
        Assertions.assertArrayEquals(expected, Fraction.fractionOptimized(cont));
    }
}
