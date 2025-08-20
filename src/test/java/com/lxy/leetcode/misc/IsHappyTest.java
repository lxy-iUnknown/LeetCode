package com.lxy.leetcode.misc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class IsHappyTest {
    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of(19, true), Arguments.of(4, false),
            Arguments.of(116, false), Arguments.of(10, true),
            Arguments.of(9999, false), Arguments.of(123456, true),
            Arguments.of(1234567890, false), Arguments.of(13, true)
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void isHappyTest(int n, boolean expected) {
        Assertions.assertEquals(expected, IsHappy.isHappy(n));
    }

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void isHappyLinkedListTest(int n, boolean expected) {
        Assertions.assertEquals(expected, IsHappy.isHappyLinkedList(n));
    }

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void isHappyMathTest(int n, boolean expected) {
        Assertions.assertEquals(expected, IsHappy.isHappyMath(n));
    }
}
