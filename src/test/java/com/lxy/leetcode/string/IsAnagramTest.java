package com.lxy.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class IsAnagramTest {
    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of("leetcode", "edocteel", true),
            Arguments.of("loveleetcode", "loveletecode", true),
            Arguments.of("anagram", "nagaram", true),
            Arguments.of("testing", "tengsit", true),
            Arguments.of("its", "sit", true),
            Arguments.of("aabbaccb", "abababab", false),
            Arguments.of("bcdefggfedcba", "aaaaaaaaaaa", false),
            Arguments.of("hello", "world", false),
            Arguments.of("hello", "hell", false),
            Arguments.of("hello", "helloo", false)
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void firstUniqueCharTest(String s, String t, boolean expected) {
        Assertions.assertEquals(expected, IsAnagram.isAnagram(s, t));
    }

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void firstUniqueCharOptimizedTest(String s, String t, boolean expected) {
        Assertions.assertEquals(expected, IsAnagram.isAnagramOptimized(s, t));
    }
}
