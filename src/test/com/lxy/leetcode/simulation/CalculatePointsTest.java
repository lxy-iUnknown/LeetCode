package com.lxy.leetcode.simulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CalculatePointsTest {
    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new String[]{"5", "2", "C", "D", "+"}, 30),
                Arguments.of(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"}, 27),
                Arguments.of(new String[]{"1"}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void calculatePointsTest(String[] operations, int expected) {
        Assertions.assertEquals(expected, CalculatePoints.calculatePoints(operations));
    }
}
