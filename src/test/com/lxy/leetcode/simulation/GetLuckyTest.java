package com.lxy.leetcode.simulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class GetLuckyTest {
    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of("zbax", 1, 17),
                Arguments.of("zbax", 2, 8),
                Arguments.of("iiii", 1, 36),
                Arguments.of("iiii", 2, 9),
                Arguments.of("iiii", 3, 9),
                Arguments.of("iiii", 10, 9),
                Arguments.of("leetcode", 1, 33),
                Arguments.of("leetcode", 2, 6),
                Arguments.of("aquickbrownfoxjumpsoverthelazydog", 1, 171),
                Arguments.of("aquickbrownfoxjumpsoverthelazydog", 2, 9),
                Arguments.of("aquickbrownfoxjumpsoverthelazydog", 10, 9),
                Arguments.of("sssssssssssssssssssss", 1, 210),
                Arguments.of("sssssssssssssssssssss", 2, 3),
                Arguments.of("rcnyobzyozawsffjnpvmtjlyxxtoxqtaaubhjxtwlvv", 7, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void getLuckyTest(String s, int k, int expected) {
        Assertions.assertEquals(expected, GetLucky.getLucky(s, k));
    }
}
