package com.lxy.leetcode.array1d;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class PivotIndexTest {

    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{1, 7, 3, 6, 5, 6}, 3),
                Arguments.of(new int[]{1, 2, 3}, -1),
                Arguments.of(new int[]{2, 1, -1}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void pivotIndex(int[] numbers, int index) {
        Assertions.assertEquals(PivotIndex.pivotIndex(numbers), index);
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void pivotIndexPrefixSum(int[] numbers, int index) {
        Assertions.assertEquals(PivotIndex.pivotIndexPrefixSum(numbers), index);
    }
}
