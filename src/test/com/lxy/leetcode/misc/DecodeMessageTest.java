package com.lxy.leetcode.misc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class DecodeMessageTest {
    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(
                        "the quick brown fox jumps over the lazy dog",
                        "vkbs bs t suepuv",
                        "this is a secret"),
                Arguments.of(
                        "eljuxhpwnyrdgtqkviszcfmabo",
                        "zwx hnfx lqantp mnoeius ycgk vcnjrdb",
                        "the five boxing wizards jump quickly")
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void decodeMessage(String key, String message, String expected) {
        Assertions.assertEquals(expected, DecodeMessage.decodeMessage(key, message));
    }
}
