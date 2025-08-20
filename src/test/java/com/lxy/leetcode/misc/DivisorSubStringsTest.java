package com.lxy.leetcode.misc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class DivisorSubStringsTest {
    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of(248, 1, 3),
            Arguments.of(123, 3, 1),
            Arguments.of(210, 2, 2),
            Arguments.of(430043, 2, 2),
            Arguments.of(1230000123, 3, 3),
            Arguments.of(1234567890, 10, 1),
            Arguments.of(1234567890, 9, 1),
            Arguments.of(1234567891, 9, 0)
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void divisorSubStringTest(int number, int k, int expected) {
        Assertions.assertEquals(expected, DivisorSubString.divisorSubstrings(number, k));
    }
}
