package com.lxy.leetcode.misc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class IsValidParenthesesTest {

    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of("()", true),
                Arguments.of("()[]{}", true),
                Arguments.of("(]", false),
                Arguments.of("((([[]]))){}{{}}{", false),
                Arguments.of("((()))))", false)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void isValidParenthesesTest(String s, boolean expected) {
        Assertions.assertEquals(expected, IsValidParentheses.isValidParentheses(s));
    }
}
