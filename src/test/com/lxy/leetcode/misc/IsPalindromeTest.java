package com.lxy.leetcode.misc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class IsPalindromeTest {
    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(-123, false),
                Arguments.of(0, true),
                Arguments.of(10, false),
                Arguments.of(123, false),
                Arguments.of(1, true),
                Arguments.of(121, true),
                Arguments.of(1234554321, true),
                Arguments.of(-1234554321, false),
                Arguments.of(1123211, true),
                Arguments.of(Integer.MAX_VALUE, false),
                Arguments.of(Integer.MIN_VALUE, false),
                Arguments.of(100001, true),
                Arguments.of(999999999, true),
                Arguments.of(1111151111, false),
                Arguments.of(111151111, true)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void isPalindromeTest(int number, boolean expected) {
        Assertions.assertEquals(expected, IsPalindrome.isPalindrome(number));
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void isPalindromeOptimizedTest(int number, boolean expected) {
        Assertions.assertEquals(expected, IsPalindrome.isPalindromeOptimized(number));
    }
}
