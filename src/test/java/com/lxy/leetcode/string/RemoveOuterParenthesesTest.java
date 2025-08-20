package com.lxy.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class RemoveOuterParenthesesTest {
    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of("(()())(())", "()()()"),
            Arguments.of("(()())(())(()(()))", "()()()()(())"),
            Arguments.of("()()", ""),
            Arguments.of("(())", "()"),
            Arguments.of("((((()))))()(())()()((()))", "(((())))()(())")
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void removeOuterParenthesesTest(String s, String expected) {
        Assertions.assertEquals(expected, RemoveOuterParentheses.removeOuterParentheses(s));
    }

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void removeOuterParenthesesOptimizedTest(String s, String expected) {
        Assertions.assertEquals(expected, RemoveOuterParentheses.removeOuterParenthesesOptimized(s));
    }
}
