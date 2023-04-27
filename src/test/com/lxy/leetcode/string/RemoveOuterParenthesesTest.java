package com.lxy.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class RemoveOuterParenthesesTest {
    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of("(()())(())", "()()()"),
                Arguments.of("(()())(())(()(()))", "()()()()(())"),
                Arguments.of("()()", ""),
                Arguments.of("(())", "()"),
                Arguments.of("((((()))))()(())()()((()))", "(((())))()(())")
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void removeOuterParenthesesTest(String s, String expected) {
        Assertions.assertEquals(expected, RemoveOuterParentheses.removeOuterParentheses(s));
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void removeOuterParenthesesOptimizedTest(String s, String expected) {
        Assertions.assertEquals(expected, RemoveOuterParentheses.removeOuterParenthesesOptimized(s));
    }
}
