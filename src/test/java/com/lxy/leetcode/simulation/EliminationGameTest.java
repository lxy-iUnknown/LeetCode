package com.lxy.leetcode.simulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class EliminationGameTest {
    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of(9, 6), Arguments.of(1, 1),
            Arguments.of(12, 6), Arguments.of(24, 14)
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void eliminationGameTest(int n, int expected) {
        Assertions.assertEquals(expected, EliminationGame.lastRemaining(n));
    }
}
