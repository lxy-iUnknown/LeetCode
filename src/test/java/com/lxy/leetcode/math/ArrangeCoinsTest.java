package com.lxy.leetcode.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class ArrangeCoinsTest {
    public static final Arguments[] ARGUMENTS = {
            Arguments.of(1, 1),
            Arguments.of(2, 1),
            Arguments.of(3, 2),
            Arguments.of(5, 2),
            Arguments.of(8, 3),
            Arguments.of(9, 3),
            Arguments.of(10, 4),
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void arrangeCoinsTest(int n, int expected) {
        Assertions.assertEquals(expected, ArrangeCoins.arrangeCoins(n));
    }
}
