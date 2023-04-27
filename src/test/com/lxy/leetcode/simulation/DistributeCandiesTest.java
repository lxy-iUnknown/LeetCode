package com.lxy.leetcode.simulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class DistributeCandiesTest {
    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(1, 4, new int[]{1, 0, 0, 0}),
                Arguments.of(7, 4, new int[]{1, 2, 3, 1}),
                Arguments.of(60, 4, new int[]{15, 18, 15, 12}),
                Arguments.of(7, 6, new int[]{1, 2, 3, 1, 0, 0}),
                Arguments.of(21, 6, new int[]{1, 2, 3, 4, 5, 6}),
                Arguments.of(7, 3, new int[]{2, 2, 3}),
                Arguments.of(10, 3, new int[]{5, 2, 3}),
                Arguments.of(40, 6, new int[]{8, 10, 7, 4, 5, 6}),
                Arguments.of(105, 7, new int[]{9, 11, 13, 15, 17, 19, 21}),
                Arguments.of(110, 7, new int[]{14, 11, 13, 15, 17, 19, 21})
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void distributeCandiesTest(int candies, int num_people, int[] expected) {
        Assertions.assertArrayEquals(expected, DistributeCandies.distributeCandies(candies, num_people));
    }
}
