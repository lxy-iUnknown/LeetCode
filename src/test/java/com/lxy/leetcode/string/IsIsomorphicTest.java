package com.lxy.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class IsIsomorphicTest {
    public static final Arguments[] ARGUMENTS = new Arguments[]{
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
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void isIsomorphicTest(String s, String t, boolean expected) {
        Assertions.assertEquals(expected, IsIsomorphic.isIsomorphic(s, t));
    }
}
