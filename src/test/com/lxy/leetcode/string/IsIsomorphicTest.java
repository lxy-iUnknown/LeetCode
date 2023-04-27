package com.lxy.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class IsIsomorphicTest {
    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of("egg", "add", true),
                Arguments.of("foo", "bar", false),
                Arguments.of("paper", "title", true),
                Arguments.of("append", "append", true),
                Arguments.of("append", "iuuxpz", true),
                Arguments.of("append", "iuwxpz", false),
                Arguments.of("append", "uuuxpz", false),
                Arguments.of("appended", "iuuxpzxa", false),
                Arguments.of("appended", "iuuxpzxz", true),
                Arguments.of("appended", "iuuxpzxaw", false),
                Arguments.of("who", "iuuxpzapl", false)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void isIsomorphicTest(String s, String t, boolean expected) {
        Assertions.assertEquals(expected, IsIsomorphic.isIsomorphic(s, t));
    }
}
