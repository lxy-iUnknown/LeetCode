package com.lxy.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class KeyboardRowTest {
    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(
                        new String[]{"Hello", "Alaska", "Dad", "Peace"},
                        new String[]{"Alaska", "Dad"}),
                Arguments.of(
                        new String[]{"omk"},
                        new String[]{}),
                Arguments.of(
                        new String[]{"adsdf", "sfd", "qwertyuiol", "qwertyuiop"},
                        new String[]{"adsdf", "sfd", "qwertyuiop"})
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void keyboardRowTest(String[] words, String[] expected) {
        Assertions.assertArrayEquals(expected, KeyboardRow.findWords(words));
    }
}
