package com.lxy.leetcode.simulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CountOperationsTest {
    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(2, 3, 3), Arguments.of(10, 10, 1),
                Arguments.of(6, 4, 3), Arguments.of(3, 10, 6),
                Arguments.of(5, 4, 5), Arguments.of(5, 3, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void countOperationsTest(int number1, int number2, int expected) {
        Assertions.assertEquals(expected, CountOperations.countOperations(number1, number2));
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void countOperationsOptimizedTest(int number1, int number2, int expected) {
        Assertions.assertEquals(expected, CountOperations.countOperationsOptimized(number1, number2));
    }
}
