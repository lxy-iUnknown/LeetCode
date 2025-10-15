package com.lxy.leetcode.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class DistMoneyTest {
    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of(23, 2, 1),
            Arguments.of(7, 10, -1),
            Arguments.of(7, 7, 0),
            Arguments.of(7, 3, 0),
            Arguments.of(30, 4, 3),
            Arguments.of(32, 4, 4),
            Arguments.of(100, 4, 3),
            Arguments.of(20, 3, 1),
            Arguments.of(16, 2, 2),
            Arguments.of(12, 2, 0),
            Arguments.of(17, 2, 1)
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void distMoneyTest(int money, int children, int expected) {
        Assertions.assertEquals(expected, DistMoney.distMoney(money, children));
    }
}
