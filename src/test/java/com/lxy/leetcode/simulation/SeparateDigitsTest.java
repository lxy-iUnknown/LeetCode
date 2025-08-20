package com.lxy.leetcode.simulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class SeparateDigitsTest {
    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of(new int[]{0},
                    new int[]{0}),
            Arguments.of(new int[]{1},
                    new int[]{1}),
            Arguments.of(new int[]{23},
                    new int[]{2, 3}),
            Arguments.of(new int[]{347},
                    new int[]{3, 4, 7}),
            Arguments.of(new int[]{9567},
                    new int[]{9, 5, 6, 7}),
            Arguments.of(new int[]{42367},
                    new int[]{4, 2, 3, 6, 7}),
            Arguments.of(new int[]{10},
                    new int[]{1, 0}),
            Arguments.of(new int[]{100},
                    new int[]{1, 0, 0}),
            Arguments.of(new int[]{1000},
                    new int[]{1, 0, 0, 0}),
            Arguments.of(new int[]{10000},
                    new int[]{1, 0, 0, 0, 0}),
            Arguments.of(new int[]{100000},
                    new int[]{1, 0, 0, 0, 0, 0}),
            Arguments.of(new int[]{1, 23, 456, 7, 9347, 40, 3, 44, 42367},
                    new int[]{1, 2, 3, 4, 5, 6, 7, 9, 3, 4, 7, 4, 0, 3, 4, 4, 4, 2, 3, 6, 7}),
            Arguments.of(new int[]{13, 25, 83, 77},
                    new int[]{1, 3, 2, 5, 8, 3, 7, 7}),
            Arguments.of(new int[]{7, 1, 3, 9},
                    new int[]{7, 1, 3, 9}),
            Arguments.of(new int[]{1, 23, 456, 7, 9347, 60, 3, 44, 42367},
                    new int[]{1, 2, 3, 4, 5, 6, 7, 9, 3, 4, 7, 6, 0, 3, 4, 4, 4, 2, 3, 6, 7}),
            Arguments.of(new int[]{10597, 48324, 3207, 78921, 465},
                    new int[]{1, 0, 5, 9, 7, 4, 8, 3, 2, 4, 3, 2, 0, 7, 7, 8, 9, 2, 1, 4, 6, 5})
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void separateDigitsTest(int[] numbers, int[] expected) {
        Assertions.assertArrayEquals(expected, SeparateDigits.separateDigits(numbers));
    }
}
