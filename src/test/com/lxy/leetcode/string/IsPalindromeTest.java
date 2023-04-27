package com.lxy.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class IsPalindromeTest {

    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of("A man, a plan, a canal: Panama", true),
                Arguments.of("race a car", false),
                Arguments.of("   ", true),
                Arguments.of("@@@ Level + & -: Sit tis level ///", true)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void isPalindromeTest(String s, boolean expected) {
        Assertions.assertEquals(expected, IsPalindrome.isPalindrome(s));
    }
}
