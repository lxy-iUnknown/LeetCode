package com.lxy.leetcode.array1d;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MaxProfitTest {

    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{7, 1, 5, 3, 6, 4}, 7),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 4),
                Arguments.of(new int[]{7, 6, 4, 3, 1}, 0),
                Arguments.of(new int[]{1, 2, 3, 5, 4, 6, 9}, 9)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void maxProfit(int[] prices, int maxProfit) {
        Assertions.assertEquals(maxProfit, MaxProfit.maxProfit(prices));
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void maxProfitGreedy(int[] prices, int maxProfit) {
        Assertions.assertEquals(maxProfit, MaxProfit.maxProfitGreedy(prices));
    }
}
