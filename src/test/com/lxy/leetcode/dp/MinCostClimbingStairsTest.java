package com.lxy.leetcode.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MinCostClimbingStairsTest {
    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{10, 15, 20}, 15),
                Arguments.of(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}, 6)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void minCostClimbingStairsTest(int[] cost, int expected) {
        Assertions.assertEquals(expected, MinCostClimbingStairs.minCostClimbingStairs(cost));
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void minCostClimbingStairsOptimizedTest(int[] cost, int expected) {
        Assertions.assertEquals(expected, MinCostClimbingStairs.minCostClimbingStairsOptimized(cost));
    }
}
