package com.lxy.leetcode.misc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class NumberToWordsTest {
    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of(0, "Zero"),
            Arguments.of(5, "Five"),
            Arguments.of(17, "Seventeen"),
            Arguments.of(45, "Forty Five"),
            Arguments.of(123, "One Hundred Twenty Three"),
            Arguments.of(12_345, "Twelve Thousand " +
                    "Three Hundred Forty Five"),
            Arguments.of(1_234_567, "One Million " +
                    "Two Hundred Thirty Four Thousand " +
                    "Five Hundred Sixty Seven"),
            Arguments.of(20_001, "Twenty Thousand One"),
            Arguments.of(20_015, "Twenty Thousand Fifteen"),
            Arguments.of(21_815, "Twenty One Thousand " +
                    "Eight Hundred Fifteen"),
            Arguments.of(15_000, "Fifteen Thousand"),
            Arguments.of(2_147_483_647, "Two Billion " +
                    "One Hundred Forty Seven Million " +
                    "Four Hundred Eighty Three Thousand " +
                    "Six Hundred Forty Seven")
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void numberToWordsTest(int number, String expected) {
        Assertions.assertEquals(expected, NumberToWords.numberToWords(number));
    }
}
