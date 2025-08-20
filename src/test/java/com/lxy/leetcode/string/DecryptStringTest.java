package com.lxy.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class DecryptStringTest {
    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of("10#11#12", "jkab"),
            Arguments.of("1326#", "acz"),
            Arguments.of("111213141516", "aaabacadaeaf"),
            Arguments.of("111213#1415#16", "aaabmadoaf"),
            Arguments.of("212223#", "babbw")
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void decryptStringTest(String s, String expected) {
        Assertions.assertEquals(expected, DecryptString.freqAlphabets(s));
    }
}
