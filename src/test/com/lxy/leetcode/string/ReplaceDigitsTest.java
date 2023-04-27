package com.lxy.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ReplaceDigitsTest {
    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of("a1c1e1", "abcdef"),
                Arguments.of("a1b2c3d4e", "abbdcfdhe")
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void replaceDigitsTest(String s, String expected) {
        Assertions.assertEquals(expected, ReplaceDigits.replaceDigits(s));
    }
}
