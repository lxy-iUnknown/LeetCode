package com.lxy.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class ReplaceDigitsTest {
    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of("a1c1e1", "abcdef"),
            Arguments.of("a1b2c3d4e", "abbdcfdhe")
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void replaceDigitsTest(String s, String expected) {
        Assertions.assertEquals(expected, ReplaceDigits.replaceDigits(s));
    }
}
