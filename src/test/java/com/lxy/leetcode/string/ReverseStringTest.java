package com.lxy.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class ReverseStringTest {
    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of(
                    new char[]{'h', 'e', 'l', 'l', 'o'},
                    new char[]{'o', 'l', 'l', 'e', 'h'}),
            Arguments.of(
                    new char[]{'q', 'u', 'i', 'c', 'k', '-', 'b', 'r', 'o', 'w', 'n', '-', 'f', 'o', 'x'},
                    new char[]{'x', 'o', 'f', '-', 'n', 'w', 'o', 'r', 'b', '-', 'k', 'c', 'i', 'u', 'q'}
            ),
            Arguments.of(
                    new char[]{'a', 'b', 's', 't', 'r', 'a', 'c', 't', 'i', 'o', 'n'},
                    new char[]{'n', 'o', 'i', 't', 'c', 'a', 'r', 't', 's', 'b', 'a'}),
            Arguments.of(
                    new char[]{'o', 'r', 'g', '.', 'j', 'u', 'n', 'i', 't', '.', 'j', 'u', 'p', 'i', 't', 'e', 'r', '.', 'p', 'a', 'r', 'a', 'm', 's', '.', 'p', 'r', 'o', 'v', 'i', 'd', 'e', 'r', '.', 'A', 'r', 'g', 'u', 'm', 'e', 'n', 't', 's'},
                    new char[]{'s', 't', 'n', 'e', 'm', 'u', 'g', 'r', 'A', '.', 'r', 'e', 'd', 'i', 'v', 'o', 'r', 'p', '.', 's', 'm', 'a', 'r', 'a', 'p', '.', 'r', 'e', 't', 'i', 'p', 'u', 'j', '.', 't', 'i', 'n', 'u', 'j', '.', 'g', 'r', 'o'})
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void reverseStringTest(char[] s, char[] expected) {
        ReverseString.reverseString(s);
        Assertions.assertArrayEquals(expected, s);
    }
}
