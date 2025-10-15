package com.lxy.leetcode.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class GetLeastFrequentDigitTest {
    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of(1553322, 1),
            Arguments.of(723344511, 2),
            Arguments.of(0, 0),
            Arguments.of(999999999, 9)
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void getLeastFrequentDigitTest(int n, int expected) {
        Assertions.assertEquals(expected, GetLeastFrequentDigit.getLeastFrequentDigit(n));
    }
}
