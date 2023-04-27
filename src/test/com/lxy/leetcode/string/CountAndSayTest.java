package com.lxy.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CountAndSayTest {
    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(1, "1"),
                Arguments.of(2, "11"),
                Arguments.of(3, "21"),
                Arguments.of(4, "1211"),
                Arguments.of(5, "111221")
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void countAndSayTest(int n, String expected) {
        Assertions.assertEquals(expected, CountAndSay.countAndSay(n));
    }
}
