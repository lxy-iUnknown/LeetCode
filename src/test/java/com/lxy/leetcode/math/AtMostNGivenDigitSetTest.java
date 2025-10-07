package com.lxy.leetcode.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class AtMostNGivenDigitSetTest {
    public static final Arguments[] ARGUMENTS = {
            Arguments.of(new String[]{"1", "3", "5", "7"}, 100, 20),
            Arguments.of(new String[]{"1", "4", "9"}, 1000000000, 29523),
            Arguments.of(new String[]{"7"}, 8, 1),
            Arguments.of(new String[]{"9"}, 8, 0),
            Arguments.of(new String[]{"1", "3", "5", "7"}, 7654, 324),
            Arguments.of(new String[]{"5","6"}, 19, 2)
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void consecutiveNumbersSumTest(String[] digits, int n, int expected) {
        Assertions.assertEquals(expected, AtMostNGivenDigitSet.atMostNGivenDigitSet(digits, n));
    }
}
