package com.lxy.leetcode.array1d;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

public class IntersectTest {

    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 2, 1}, new int[]{2, 2}, new int[]{2, 2}),
                Arguments.of(new int[]{1, 2, 2, 1}, new int[]{2}, new int[]{2}),
                Arguments.of(new int[]{1, 2, 2, 1, 3, 3, 3, 3, 3}, new int[]{2, 2, 3, 3, 3}, new int[]{2, 2, 3, 3, 3}),
                Arguments.of(new int[]{1, 2, 1, 3, 3, 3, 3, 3}, new int[]{2, 2, 3, 3, 3}, new int[]{2, 3, 3, 3}),
                Arguments.of(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}, new int[]{4, 9})
        );
    }

    private static void checkResult(int[] expected, int[] actual) {
        Arrays.sort(actual);
        Assertions.assertArrayEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void intersect(int[] numbers1, int[] numbers2, int[] expected) {
        int[] actual = Intersect.intersect(numbers1, numbers2);
        Arrays.sort(actual);
        Assertions.assertArrayEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void intersectHashMap(int[] numbers1, int[] numbers2, int[] expected) {
        int[] actual = Intersect.intersectHashMap(numbers1, numbers2);
        Arrays.sort(actual);
        Assertions.assertArrayEquals(expected, actual);
    }
}
