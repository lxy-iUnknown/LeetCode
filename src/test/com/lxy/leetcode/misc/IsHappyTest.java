package com.lxy.leetcode.misc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class IsHappyTest {
    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(19, true), Arguments.of(4, false),
                Arguments.of(116, false), Arguments.of(10, true),
                Arguments.of(9999, false), Arguments.of(123456, true),
                Arguments.of(1234567890, false), Arguments.of(13, true)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void isHappyTest(int n, boolean expected) {
        Assertions.assertEquals(expected, IsHappy.isHappy(n));
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void isHappyLinkedListTest(int n, boolean expected) {
        Assertions.assertEquals(expected, IsHappy.isHappyLinkedList(n));
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void isHappyMathTest(int n, boolean expected) {
        Assertions.assertEquals(expected, IsHappy.isHappyMath(n));
    }
}
