package com.lxy.leetcode.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class MinMaxDifferenceTest {
    public static final Arguments[] ARGUMENTS = {
            Arguments.of(100000000, 900000000),
            Arguments.of(122784142, 900000900),
            Arguments.of(90, 99),
            Arguments.of(91891, 98098),
            Arguments.of(999818, 999101),
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void minMaxDifferenceTest(int n, int expected) {
        Assertions.assertEquals(expected, MinMaxDifference.minMaxDifference(n));
    }
}
