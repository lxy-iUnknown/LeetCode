package com.lxy.leetcode.array1d;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

public class MergeSortedArrayTest {

    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 2, 3},
                        new int[]{2, 4, 5},
                        new int[]{1, 2, 2, 2, 3, 4, 5}),
                Arguments.of(new int[]{1, 2, 2, 3},
                        new int[]{},
                        new int[]{1, 2, 2, 3}),
                Arguments.of(new int[]{},
                        new int[]{1, 2, 3, 4},
                        new int[]{1, 2, 3, 4}),
                Arguments.of(new int[]{1, 2, 3, 4, 5},
                        new int[]{6, 7, 8, 9, 10, 11},
                        new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}),
                Arguments.of(new int[]{1, 3, 4, 7, 10, 15},
                        new int[]{0, 2, 5, 6, 8, 10, 11, 20},
                        new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 10, 10, 11, 15, 20})
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void mergeSortedArrayTest(int[] numbers1, int[] numbers2, int[] expected) {
        int m = numbers1.length;
        int n = numbers2.length;
        int[] numbers = Arrays.copyOf(numbers1, m + n);
        MergeSortedArray.mergeSortedArray(numbers, m, numbers2, n);
        Assertions.assertArrayEquals(expected, numbers);
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void mergeSortedArrayOptimizedTest(int[] numbers1, int[] numbers2, int[] expected) {
        int m = numbers1.length;
        int n = numbers2.length;
        int[] numbers = Arrays.copyOf(numbers1, m + n);
        MergeSortedArray.mergeSortedArrayOptimized(numbers, m, numbers2, n);
        Assertions.assertArrayEquals(expected, numbers);
    }
}
