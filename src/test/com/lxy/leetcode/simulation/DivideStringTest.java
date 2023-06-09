package com.lxy.leetcode.simulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class DivideStringTest {
    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of("abcdefghi", 3, 'x',
                        new String[]{"abc", "def", "ghi"}),
                Arguments.of("abcdefghij", 3, 'x',
                        new String[]{"abc", "def", "ghi", "jxx"}),
                Arguments.of("abcdefghijklmnopq", 5, 'w',
                        new String[]{"abcde", "fghij", "klmno", "pqwww"}),
                Arguments.of("abcdef", 10, 'p',
                        new String[]{"abcdefpppp"}),
                Arguments.of("abcde", 1, 'm',
                        new String[]{"a", "b", "c", "d", "e"})
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void divideStringTest(String s, int k, char fill, String[] expected) {
        Assertions.assertArrayEquals(expected, DivideString.divideString(s, k, fill));
    }
}
