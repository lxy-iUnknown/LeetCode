package com.lxy.leetcode.misc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class RomanToIntTest {
    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of("I", 1),
                Arguments.of("III", 3),
                Arguments.of("IV", 4),
                Arguments.of("VI", 6),
                Arguments.of("IX", 9),
                Arguments.of("LVIII", 58),
                Arguments.of("CDXXXV", 435),
                Arguments.of("DCCCXCIX", 899),
                Arguments.of("MCMXCIV", 1994),
                Arguments.of("MDCCCLXXX", 1880),
                Arguments.of("MMCCCLXXVIII", 2378),
                Arguments.of("MMMCMXCIX", 3999)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void romanToIntTest(String s, int expected) {
        Assertions.assertEquals(expected, RomanToInt.romanToInt(s));
    }
}
