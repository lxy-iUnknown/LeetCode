package com.lxy.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class DecryptStringTest {
    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of("10#11#12", "jkab"),
                Arguments.of("1326#", "acz"),
                Arguments.of("111213141516", "aaabacadaeaf"),
                Arguments.of("111213#1415#16", "aaabmadoaf"),
                Arguments.of("212223#", "babbw")
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void decryptStringTest(String s, String expected) {
        Assertions.assertEquals(expected, DecryptString.freqAlphabets(s));
    }
}
