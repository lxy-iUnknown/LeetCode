package com.lxy.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class IsOneBitCharacterTest {
    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of(new int[]{0, 0, 0, 1, 1, 1, 0}, false),
            Arguments.of(new int[]{0, 0, 0, 1, 1, 1, 0, 0}, true),
            Arguments.of(new int[]{0, 1, 0, 0, 1, 1, 1, 0}, false),
            Arguments.of(new int[]{1, 1, 0}, true),
            Arguments.of(new int[]{1, 1, 1, 0}, false),
            Arguments.of(new int[]{1, 0, 1, 1, 0, 1, 1, 0}, true),
            Arguments.of(new int[]{1, 0, 1, 1, 1, 0}, false)
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void isOneBitCharacterTest(int[] bits, boolean expected) {
        Assertions.assertEquals(expected, IsOneBitCharacter.isOneBitCharacter(bits));
    }
}
