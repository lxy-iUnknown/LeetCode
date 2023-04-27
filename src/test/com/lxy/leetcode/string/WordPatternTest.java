package com.lxy.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class WordPatternTest {
    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of("abba", "dog cat cat dog", true),
                Arguments.of("aaaa", "dog dog dog dog", true),
                Arguments.of("abcfdef", "dog cat mouse they ice it they", true),
                Arguments.of("abba", "dog cat cat fish", false),
                Arguments.of("abbbc", "dog dog cat mouse fish", false),
                Arguments.of("abcdef", "mouse mouse mouse dog it may", false),
                Arguments.of("abcdef", "mouse dog it may choose what kind kind", false),
                Arguments.of("abcfdef", "dog cat mouse they ice", false)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void wordPatternTest(String pattern, String s, boolean expected) {
        Assertions.assertEquals(expected, WordPattern.wordPattern(pattern, s));
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void wordPatternOptimizedTest(String pattern, String s, boolean expected) {
        Assertions.assertEquals(expected, WordPattern.wordPatternOptimized(pattern, s));
    }
}
