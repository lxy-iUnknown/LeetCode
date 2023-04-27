package com.lxy.leetcode.simulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class AddBinaryTest {

    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of("11", "1", "100"),
                Arguments.of("1010", "1011", "10101"),
                Arguments.of("101111", "10", "110001"),
                Arguments.of("1000111010111", "1111011", "1001001010010"),
                Arguments.of("1000110010111", "1011011", "1000111110010"),
                Arguments.of("1111101001", "1010100110", "11010001111"),
                Arguments.of("1000000000", "1000000000", "10000000000"),
                Arguments.of("1000000011", "1000000001", "10000000100"),
                Arguments.of("11111111", "11111111", "111111110"),
                Arguments.of("111111111111", "11111111", "1000011111110")
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void addBinaryTest(String a, String b, String expected) {
        Assertions.assertEquals(expected, AddBinary.addBinary(a, b));
    }
}
