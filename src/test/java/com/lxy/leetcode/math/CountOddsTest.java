package com.lxy.leetcode.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class CountOddsTest {
    public static final Arguments[] ARGUMENTS = {
            Arguments.of(3, 7, 3),
            Arguments.of(8, 10, 1),
            Arguments.of(8, 11, 2),
            Arguments.of(9, 13, 3),
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void coundOddsTest(int left, int right, int expected) {
        Assertions.assertEquals(expected, CountOdds.countOdds(left, right));
    }
}
