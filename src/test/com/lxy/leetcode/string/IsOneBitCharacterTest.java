package com.lxy.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class IsOneBitCharacterTest {
    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{0, 0, 0, 1, 1, 1, 0}, false),
                Arguments.of(new int[]{0, 0, 0, 1, 1, 1, 0, 0}, true),
                Arguments.of(new int[]{0, 1, 0, 0, 1, 1, 1, 0}, false),
                Arguments.of(new int[]{1, 1, 0}, true),
                Arguments.of(new int[]{1, 1, 1, 0}, false),
                Arguments.of(new int[]{1, 0, 1, 1, 0, 1, 1, 0}, true),
                Arguments.of(new int[]{1, 0, 1, 1, 1, 0}, false)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void isOneBitCharacterTest(int[] bits, boolean expected) {
        Assertions.assertEquals(expected, IsOneBitCharacter.isOneBitCharacter(bits));
    }
}
