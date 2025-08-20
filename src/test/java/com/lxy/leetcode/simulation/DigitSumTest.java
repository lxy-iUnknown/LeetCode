package com.lxy.leetcode.simulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class DigitSumTest {
    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of("11111222223", 3, "135"),
            Arguments.of("11111222223", 4, "477"),
            Arguments.of("00000000", 3, "000"),
            Arguments.of("0123456789876543210", 2, "27"),
            Arguments.of("0123456789876543210", 6, "180"),
            Arguments.of("0123456789876543210", 3, "126")
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void digitSum(String s, int k, String expected) {
        Assertions.assertEquals(expected, DigitSum.digitSum(s, k));
    }
}
