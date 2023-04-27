package com.lxy.leetcode.array1d;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class DecodeArrayTest {
    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, 1, new int[]{1, 0, 2, 1}),
                Arguments.of(new int[]{6, 2, 7, 3}, 4, new int[]{4, 2, 0, 7, 4})
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void decodeArrayTest(int[] encoded, int first, int[] expected) {
        Assertions.assertArrayEquals(expected, DecodeArray.decodeArray(encoded, first));
    }
}
