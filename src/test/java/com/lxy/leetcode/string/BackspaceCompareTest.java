package com.lxy.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class BackspaceCompareTest {
    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of("bxj##tw", "bxo#j##tw", true),
            Arguments.of("bxj##tw", "bxj###tw", false),
            Arguments.of("xywrrmp", "xywrrmu#p", true),
            Arguments.of("ab##", "c#d#", true),
            Arguments.of("ab#c", "ad#c", true),
            Arguments.of("avb#c", "axd#c", false),
            Arguments.of("a#c", "b", false),
            Arguments.of("fad##", "fbc##", true),
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void backspaceCompareTest(String s, String t, boolean expected) {
        Assertions.assertEquals(expected, BackspaceCompare.backspaceCompare(s, t));
    }
}
