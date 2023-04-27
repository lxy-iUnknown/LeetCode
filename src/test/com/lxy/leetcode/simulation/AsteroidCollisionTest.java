package com.lxy.leetcode.simulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class AsteroidCollisionTest {
    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{5, 10, -5}, new int[]{5, 10}),
                Arguments.of(new int[]{8, -8}, new int[]{}),
                Arguments.of(new int[]{10, 2, -5}, new int[]{10}),
                Arguments.of(new int[]{-2, -1, 1, 2}, new int[]{-2, -1, 1, 2}),
                Arguments.of(new int[]{10, 3, 7, -1, -8, -9}, new int[]{10}),
                Arguments.of(new int[]{100, 50, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, -20}, new int[]{100, 50})
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void asteroidCollisionTest(int[] asteroids, int[] expected) {
        Assertions.assertArrayEquals(expected, AsteroidCollision.asteroidCollision(asteroids));
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void asteroidCollisionLoopTest(int[] asteroids, int[] expected) {
        Assertions.assertArrayEquals(expected, AsteroidCollision.asteroidCollisionLoop(asteroids));
    }
}
