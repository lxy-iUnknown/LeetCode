package com.lxy.leetcode.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class DivisorGameTest {
    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of(2, true), Arguments.of(3, false),
            Arguments.of(4, true), Arguments.of(7, false)
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void divisorGameTest(int n, boolean expected) {
        Assertions.assertEquals(expected, DivisorGame.divisorGame(n));
    }
}
