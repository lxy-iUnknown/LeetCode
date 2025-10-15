package com.lxy.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class NumDifferentIntegersTest {
    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of("abcd123bc34d8ef34abcd", 3),
            Arguments.of("abcdefghijklmn", 0),
            Arguments.of("abcdefghijklmn1234", 1),
            Arguments.of("0a0", 1),
            Arguments.of("abcdef0123abcdef0123abcdef01234", 2),
            Arguments.of("1234abcdefghijklmn", 1),
            Arguments.of("leet1234code234", 2),
            Arguments.of("a1b01c001", 1),
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void numDifferentIntegersTest(String word, int expected) {
        Assertions.assertEquals(expected, NumDifferentIntegers.numDifferentIntegers(word));
    }
}
