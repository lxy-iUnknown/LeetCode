package com.lxy.leetcode.simulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class ExecuteInstructionsTest {
    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of(3, new int[]{0, 1}, "RRDDLU", new int[]{1, 5, 4, 3, 1, 0}),
            Arguments.of(2, new int[]{1, 1}, "LURD", new int[]{4, 1, 0, 0}),
            Arguments.of(1, new int[]{0, 0}, "LRUD", new int[]{0, 0, 0, 0})
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void executeInstructions(int n, int[] startPos, String s, int[] expected) {
        Assertions.assertArrayEquals(expected, ExecuteInstructions.executeInstructions(n, startPos, s));
    }
}
