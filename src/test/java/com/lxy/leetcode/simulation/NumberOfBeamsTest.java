package com.lxy.leetcode.simulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class NumberOfBeamsTest {
    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of(new String[]{
                    "011001",
                    "000000",
                    "010100",
                    "001000"
            }, 8),
            Arguments.of(new String[]{
                    "000",
                    "111",
                    "000"
            }, 0),
            Arguments.of(new String[]{
                    "000",
                    "000",
                    "000",
                    "000",
                    "000",
                    "111",
            }, 0),
            Arguments.of(new String[]{
                    "000",
                    "111",
                    "000",
                    "000",
                    "000",
                    "000",
                    "000",
            }, 0),
            Arguments.of(new String[]{
                    "000",
                    "111",
                    "010",
                    "111"
            }, 6),
            Arguments.of(new String[]{
                    "000",
                    "111",
                    "000",
                    "111"
            }, 9),
            Arguments.of(new String[]{
                    "011001",
                    "100010",
                    "010100",
                    "001010"
            }, 14),
            Arguments.of(new String[]{
                    "011001",
                    "000000",
                    "000000",
                    "000000",
                    "010110",
                    "001000"
            }, 12)
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void numberOfBeamsTest(String[] bank, int expected) {
        Assertions.assertEquals(expected, NumberOfBeams.numberOfBeams(bank));
    }

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void numberOfBeamsSimplifiedTest(String[] bank, int expected) {
        Assertions.assertEquals(expected, NumberOfBeams.numberOfBeamsSimplified(bank));
    }
}
