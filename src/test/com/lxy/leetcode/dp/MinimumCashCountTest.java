package com.lxy.leetcode.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MinimumCashCountTest {

    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(0, 0), Arguments.of(1, 1),
                Arguments.of(2, 2), Arguments.of(3, 3),
                Arguments.of(4, 4), Arguments.of(5, 1),
                Arguments.of(6, 2), Arguments.of(7, 3),
                Arguments.of(8, 4), Arguments.of(9, 5),
                Arguments.of(10, 2), Arguments.of(11, 1),
                Arguments.of(12, 2), Arguments.of(13, 3),
                Arguments.of(14, 4), Arguments.of(15, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void minimumCashTest(int n, int expected) {
        Assertions.assertEquals(expected, MinimumCashCount.minimumCashCount(n));
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void minimumCashCyclicBufferTest(int n, int expected) {
        Assertions.assertEquals(expected, MinimumCashCount.minimumCashCountCyclicBuffer(n));
    }
}
