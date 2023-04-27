package com.lxy.leetcode.simulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CanPlaceFlowersTest {
    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.arguments(new int[]{1}, 0, true),
                Arguments.arguments(new int[]{0}, 0, true),
                Arguments.arguments(new int[]{0, 0}, 0, true),
                Arguments.arguments(new int[]{0, 0}, 1, true),
                Arguments.arguments(new int[]{1, 0}, 0, true),
                Arguments.arguments(new int[]{1, 0}, 1, false),
                Arguments.arguments(new int[]{0, 1}, 0, true),
                Arguments.arguments(new int[]{0, 1}, 1, false),
                Arguments.arguments(new int[]{0, 0}, 2, false),
                Arguments.arguments(new int[]{0, 1, 0}, 1, false),
                Arguments.arguments(new int[]{0, 1, 0}, 2, false),
                Arguments.arguments(new int[]{0, 0, 0}, 2, true),
                Arguments.arguments(new int[]{0, 0, 0}, 3, false),
                Arguments.arguments(new int[]{0, 1, 0, 0}, 1, true),
                Arguments.arguments(new int[]{0, 1, 0, 0}, 2, false),
                Arguments.of(new int[]{1, 0, 0, 0, 1}, 1, true),
                Arguments.of(new int[]{1, 0, 0, 0, 1}, 2, false),
                Arguments.of(new int[]{1, 0, 0, 0, 1}, 5, false),
                Arguments.of(new int[]{0, 0, 0, 0, 1, 0, 0, 0}, 2, true),
                Arguments.of(new int[]{0, 0, 0, 0, 1, 0, 0, 0}, 3, true),
                Arguments.of(new int[]{0, 0, 0, 0, 1, 0, 0, 0}, 6, false),
                Arguments.of(new int[]{0, 1, 0, 1, 0, 1, 0, 0}, 1, true),
                Arguments.of(new int[]{0, 1, 0, 1, 0, 1, 0, 0}, 2, false),
                Arguments.of(new int[]{0, 1, 0, 1, 0, 1, 0, 1, 0}, 0, true),
                Arguments.of(new int[]{0, 1, 0, 1, 0, 1, 0, 1, 0}, 1, false),
                Arguments.of(new int[]{0, 1, 0, 1, 0, 1, 0, 1, 0, 1}, 0, true),
                Arguments.of(new int[]{0, 1, 0, 1, 0, 1, 0, 1, 0, 1}, 1, false),
                Arguments.of(new int[]{0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0}, 3, true),
                Arguments.of(new int[]{0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0}, 4, false)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void canPlaceFlowerTest(int[] flowerBed, int n, boolean expected) {
        Assertions.assertEquals(expected, CanPlaceFlowers.canPlaceFlowers(flowerBed, n));
    }
}
