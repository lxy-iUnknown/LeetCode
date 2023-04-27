package com.lxy.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ReverseVowelsTest {
    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of("hello", "holle"),
                Arguments.of("leetcode", "leotcede"),
                Arguments.of("thE quick brOwn fox jumps over the lAzy dog",
                        "tho qAeck brewn fox jumps ovOr thi luzy dEg")
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void reverseVowelsTest(String s, String expected) {
        Assertions.assertEquals(expected, ReverseVowels.reverseVowels(s));
    }
}
