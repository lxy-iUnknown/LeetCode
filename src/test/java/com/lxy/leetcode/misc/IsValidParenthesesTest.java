package com.lxy.leetcode.misc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class IsValidParenthesesTest {

    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of("()", true),
            Arguments.of("()[]{}", true),
            Arguments.of("(]", false),
            Arguments.of("((([[]]))){}{{}}{", false),
            Arguments.of("((()))))", false)
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void isValidParenthesesTest(String s, boolean expected) {
        Assertions.assertEquals(expected, IsValidParentheses.isValidParentheses(s));
    }
}
