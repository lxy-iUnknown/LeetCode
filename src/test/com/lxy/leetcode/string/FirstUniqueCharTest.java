package com.lxy.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class FirstUniqueCharTest {
    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of("leetcode", 0),
                Arguments.of("loveleetcode", 2),
                Arguments.of("aabbaccb", -1),
                Arguments.of("bcdefggfedcba", 12)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void firstUniqueCharTest(String s, int expected) {
        Assertions.assertEquals(expected, FirstUniqueChar.firstUniqueChar(s));
    }
}
