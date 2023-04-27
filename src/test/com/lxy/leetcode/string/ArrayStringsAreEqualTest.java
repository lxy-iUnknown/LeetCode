package com.lxy.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ArrayStringsAreEqualTest {
    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(
                        new String[]{"ab", "c"},
                        new String[]{"abc"}, true),
                Arguments.of(
                        new String[]{"abc", "d", "efg"},
                        new String[]{"abcdef", "g"}, true),
                Arguments.of(
                        new String[]{"abcdefg"},
                        new String[]{"ab", "cde", "fg"}, true),
                Arguments.of(
                        new String[]{"abcdefg"},
                        new String[]{"ab", "cde", "fgh"}, false),
                Arguments.of(
                        new String[]{"12", "3456789", "0"},
                        new String[]{"1234", "5", "6", "7", "99", "0"}, false),
                Arguments.of(
                        new String[]{"12345", "67890"},
                        new String[]{"1234", "5", "6", "7", "8901"}, false),
                Arguments.of(
                        new String[]{"12", "3456789", "0", "123456"},
                        new String[]{"1234", "5", "6", "7", "8901"}, false)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void arrayStringsAreEqualTest(String[] words1, String[] words2, boolean expected) {
        Assertions.assertEquals(expected, ArrayStringsAreEqual.arrayStringsAreEqual(words1, words2));
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void arrayStringsAreEqualOptimizedTest(String[] words1, String[] words2, boolean expected) {
        Assertions.assertEquals(expected, ArrayStringsAreEqual.arrayStringsAreEqualOptimized(words1, words2));
    }
}
