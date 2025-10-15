package com.lxy.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class ReorderSpacesTest {
    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of("  this   is  a sentence ", "this   is   a   sentence"),
            Arguments.of(" practice   makes   perfect", "practice   makes   perfect "),
            Arguments.of("  walks  udp package   into  bar a", "walks  udp  package  into  bar  a "),
            Arguments.of("   test", "test   "),
            Arguments.of("hello  world", "hello  world"),
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void isPalindromeTest(String s, String expected) {
        Assertions.assertEquals(expected, ReorderSpaces.reorderSpaces(s));
    }
}
