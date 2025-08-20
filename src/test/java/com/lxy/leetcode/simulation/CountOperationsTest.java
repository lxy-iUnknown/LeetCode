package com.lxy.leetcode.simulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class CountOperationsTest {
    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of(2, 3, 3), Arguments.of(10, 10, 1),
            Arguments.of(6, 4, 3), Arguments.of(3, 10, 6),
            Arguments.of(5, 4, 5), Arguments.of(5, 3, 4)
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void countOperationsTest(int number1, int number2, int expected) {
        Assertions.assertEquals(expected, CountOperations.countOperations(number1, number2));
    }

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void countOperationsOptimizedTest(int number1, int number2, int expected) {
        Assertions.assertEquals(expected, CountOperations.countOperationsOptimized(number1, number2));
    }
}
