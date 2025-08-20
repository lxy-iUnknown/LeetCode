package com.lxy.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class ReverseVowelsTest {
    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of("hello", "holle"),
            Arguments.of("leetcode", "leotcede"),
            Arguments.of("thE quick brOwn fox jumps over the lAzy dog",
                    "tho qAeck brewn fox jumps ovOr thi luzy dEg")
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void reverseVowelsTest(String s, String expected) {
        Assertions.assertEquals(expected, ReverseVowels.reverseVowels(s));
    }
}
