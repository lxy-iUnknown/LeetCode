package com.lxy.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class KeyboardRowTest {
    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of(
                    new String[]{"Hello", "Alaska", "Dad", "Peace"},
                    new String[]{"Alaska", "Dad"}),
            Arguments.of(
                    new String[]{"omk"},
                    new String[]{}),
            Arguments.of(
                    new String[]{"adsdf", "sfd", "qwertyuiol", "qwertyuiop"},
                    new String[]{"adsdf", "sfd", "qwertyuiop"})
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void keyboardRowTest(String[] words, String[] expected) {
        Assertions.assertArrayEquals(expected, KeyboardRow.findWords(words));
    }
}
