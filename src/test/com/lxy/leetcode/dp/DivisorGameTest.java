package com.lxy.leetcode.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class DivisorGameTest {
    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(2, true), Arguments.of(3, false),
                Arguments.of(4, true), Arguments.of(7, false)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void divisorGameTest(int n, boolean expected) {
        Assertions.assertEquals(expected, DivisorGame.divisorGame(n));
    }
}
