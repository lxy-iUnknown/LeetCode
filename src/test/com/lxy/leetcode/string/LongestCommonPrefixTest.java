package com.lxy.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class LongestCommonPrefixTest {
    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new String[]{
                        "flower", "flight", "flow"}, "fl"),
                Arguments.of(new String[]{
                        "car", "cart", "common", "dog", "different"}, ""),
                Arguments.of(new String[]{
                        "hard", "harden", "hardly", "hardening", "hardened", "harder", "hardest"}, "hard"),
                Arguments.of(new String[]{
                        "test", "test", "test", "test"}, "test"),
                Arguments.of(new String[]{
                        "person", "perceive", "percent"}, "per")
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void longestCommonPrefixVerticalTest(String[] strings, String expected) {
        Assertions.assertEquals(expected, LongestCommonPrefix.longestCommonPrefixVertical(strings));
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void longestCommonPrefixHorizontalTest(String[] strings, String expected) {
        Assertions.assertEquals(expected, LongestCommonPrefix.longestCommonPrefixHorizontal(strings));
    }
}
