package com.lxy.leetcode.simulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class NumWaterBottlesTest {
    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(15, 4, 19), Arguments.of(9, 3, 13),
                Arguments.of(5, 10, 5), Arguments.of(15, 3, 22)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void numWaterBottlesTest(int numBottles, int numExchange, int expected) {
        Assertions.assertEquals(expected, NumWaterBottles.numWaterBottles(numBottles, numExchange));
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void numWaterBottlesOptimizedTest(int numBottles, int numExchange, int expected) {
        Assertions.assertEquals(expected, NumWaterBottles.numWaterBottlesOptimized(numBottles, numExchange));
    }
}
