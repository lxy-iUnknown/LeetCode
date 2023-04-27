package com.lxy.leetcode.misc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class IntToRomanTest {
    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(1, "I"),
                Arguments.of(3, "III"),
                Arguments.of(4, "IV"),
                Arguments.of(6, "VI"),
                Arguments.of(9, "IX"),
                Arguments.of(58, "LVIII"),
                Arguments.of(435, "CDXXXV"),
                Arguments.of(899, "DCCCXCIX"),
                Arguments.of(1994, "MCMXCIV"),
                Arguments.of(1880, "MDCCCLXXX"),
                Arguments.of(2378, "MMCCCLXXVIII"),
                Arguments.of(3888, "MMMDCCCLXXXVIII"),
                Arguments.of(3999, "MMMCMXCIX")
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void intToRomanTest(int number, String expected) {
        Assertions.assertEquals(expected, IntToRoman.intToRoman(number));
    }
}
