package com.lxy.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class IsAlienSortedTest {
    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of(
                    new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz", true
            ),
            Arguments.of(
                    new String[]{"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz", false
            ),
            Arguments.of(
                    new String[]{"apple", "app"}, "abcdefghijklmnopqrstuvwxyz", false
            )
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void isAlienSortedTest(String[] words, String order, boolean expected) {
        Assertions.assertEquals(expected, IsAlienSorted.isAlienSorted(words, order));
    }
}
