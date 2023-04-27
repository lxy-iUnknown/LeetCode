package com.lxy.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class StringToIntegerTest {
    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of("123456", 123456),
                Arguments.of("-123456", -123456),
                Arguments.of("+123456", 123456),
                Arguments.of("1234567890", 1234567890),
                Arguments.of("+1234567890", 1234567890),
                Arguments.of("-1234567890", -1234567890),
                Arguments.of("2147483647", 2147483647),
                Arguments.of("-2147483647", -2147483647),
                Arguments.of("-2147483648", -2147483648),
                Arguments.of("-2147483649", Integer.MIN_VALUE),
                Arguments.of("2147483648", Integer.MAX_VALUE),
                Arguments.of("-999999999999999", Integer.MIN_VALUE),
                Arguments.of("999999999999999", Integer.MAX_VALUE),
                Arguments.of("-", 0),
                Arguments.of("+", 0),
                Arguments.of("words and 987", 0),
                Arguments.of("abcdefg", 0),
                Arguments.of("       ", 0),
                Arguments.of("       with words", 0),
                Arguments.of("      123456", 123456),
                Arguments.of("      123456a", 123456),
                Arguments.of("      123456 with words", 123456),
                Arguments.of("      -", 0),
                Arguments.of("      +", 0),
                Arguments.of("    0000000000000000000000", 0),
                Arguments.of("    0000000000123456", 123456),
                Arguments.of("    -0000000000123456", -123456),
                Arguments.of("    +0000000000123456", 123456),
                Arguments.of("        -2147483647", -2147483647),
                Arguments.of("        -2147483648", -2147483648),
                Arguments.of("        -2147483649", Integer.MIN_VALUE),
                Arguments.of("        2147483648", Integer.MAX_VALUE),
                Arguments.of("-00000002147483647", -2147483647),
                Arguments.of("-00000002147483648", -2147483648),
                Arguments.of("-00000002147483649", Integer.MIN_VALUE),
                Arguments.of("00000002147483648", Integer.MAX_VALUE),
                Arguments.of("    -00000000010000000000000", Integer.MIN_VALUE),
                Arguments.of("    00000000010000000000000", Integer.MAX_VALUE)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void stringToIntegerTest(String s, int expected) {
        Assertions.assertEquals(StringToInteger.stringToInteger(s), expected);
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void stringToIntegerOptimizedTest(String s, int expected) {
        Assertions.assertEquals(StringToInteger.stringToIntegerOptimized(s), expected);
    }
}
