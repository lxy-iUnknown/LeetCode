package com.lxy.leetcode.simulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class FindFinalValueTest {
    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of(new int[]{5, 3, 6, 1, 12}, 3, 24),
            Arguments.of(new int[]{5, 3, 6, 1, 6, 6, 12, 4, 6, 6}, 3, 24),
            Arguments.of(new int[]{2, 7, 9}, 4, 4),
            Arguments.of(new int[]{160, 5, 10, 80, 20, 40}, 5, 320),
            Arguments.of(new int[]{5, 3, 6, 1, 12}, 7, 7),
            Arguments.of(new int[]{5, 3, 6, 1, 13}, 6, 12),
            Arguments.of(new int[]{1, 16, 13, 19, 12, 10}, 2, 2)
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void findFinalValueTest(int[] numbers, int original, int expected) {
        Assertions.assertEquals(expected, FindFinalValue.findFinalValue(numbers, original));
    }

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void findFinalValueHashSetTest(int[] numbers, int original, int expected) {
        Assertions.assertEquals(expected, FindFinalValue.findFinalValueHashSet(numbers, original));
    }

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void findFinalValueBitSetTest(int[] numbers, int original, int expected) {
        Assertions.assertEquals(expected, FindFinalValue.findFinalValueBitSet(numbers, original));
    }

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void findFinalValueBitMaskTest(int[] numbers, int original, int expected) {
        Assertions.assertEquals(expected, FindFinalValue.findFinalValueBitMask(numbers, original));
    }
}
