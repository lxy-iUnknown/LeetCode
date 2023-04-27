package com.lxy.leetcode.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ClimbStairsTest {

    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(1, 1), Arguments.of(2, 2), Arguments.of(3, 3),
                Arguments.of(4, 5), Arguments.of(5, 8), Arguments.of(6, 13),
                Arguments.of(7, 21), Arguments.of(8, 34), Arguments.of(9, 55)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void climbStairsTest(int n, int expected) {
        Assertions.assertEquals(expected, ClimbStairs.climbStairs(n));
    }
}
