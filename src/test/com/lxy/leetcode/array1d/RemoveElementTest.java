package com.lxy.leetcode.array1d;

import com.lxy.leetcode.util.TestUtil;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class RemoveElementTest {

    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(
                        new int[]{4, 3, 2, 1, 5, 6, 7, 0, 8, 10, 3},
                        11,
                        new int[]{4, 3, 2, 1, 5, 6, 7, 0, 8, 10, 3}),
                Arguments.of(
                        new int[]{3, 2, 2, 3},
                        3,
                        new int[]{2, 2}),
                Arguments.of(
                        new int[]{0, 1, 2, 2, 3, 0, 4, 2},
                        2,
                        new int[]{0, 1, 4, 0, 3}),
                Arguments.of(
                        new int[]{0, 1, 2, 2, 3, 0, 8, 7, 2, 5, 2},
                        2,
                        new int[]{0, 1, 3, 0, 8, 7, 5}),
                Arguments.of(
                        new int[]{4, 8, 9, 0, 0, 5, 3, 2, 0, 1, 2, 0, 0, 5, 6, 7},
                        0,
                        new int[]{4, 8, 9, 5, 3, 2, 1, 2, 5, 6, 7}),
                Arguments.of(
                        new int[]{4, 3, 2, 3, 3, 3, 7, 0, 8, 10, 3},
                        3,
                        new int[]{4, 2, 7, 0, 8, 10}),
                Arguments.of(
                        new int[]{3, 3, 3, 3, 3, 3, 3, 3, 3, 2},
                        3,
                        new int[]{2}),
                Arguments.of(
                        new int[]{3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
                        3,
                        new int[]{}),
                Arguments.of(
                        new int[]{6, 8, 9, 10, 0, 2, 3, 5, 7, 1, 9, 6},
                        6,
                        new int[]{8, 9, 10, 0, 2, 3, 5, 7, 1, 9}),
                Arguments.of(
                        new int[]{4, 8, 9, 10, 0, 2, 3, 5, 7, 1, 9, 6},
                        6,
                        new int[]{4, 8, 9, 10, 0, 2, 3, 5, 7, 1, 9}),
                Arguments.of(
                        new int[]{4, 8, 9, 10, 0, 2, 3, 5, 7, 1, 9, 6},
                        11,
                        new int[]{4, 8, 9, 10, 0, 2, 3, 5, 7, 1, 9, 6})
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void removeElementTest(int[] numbers, int value, int[] expected) {
        TestUtil.assertArrayUnorderedEquals(expected, numbers,
                RemoveElement.removeElement(numbers, value));
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void removeElementOptimizedTest(int[] numbers, int value, int[] expected) {
        TestUtil.assertArrayUnorderedEquals(expected, numbers,
                RemoveElement.removeElementOptimized(numbers, value));
    }
}
