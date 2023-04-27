package com.lxy.leetcode.array1d;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class GetMaximumGeneratedTest {
    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(7, 3), Arguments.of(2, 1),
                Arguments.of(3, 2), Arguments.of(0, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void getMaximumGeneratedTest(int n, int expected) {
        Assertions.assertEquals(expected, GetMaximumGenerated.getMaximumGenerated(n));
    }
}
