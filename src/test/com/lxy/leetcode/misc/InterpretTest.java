package com.lxy.leetcode.misc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class InterpretTest {
    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of("G()(al)", "Goal"),
                Arguments.of("G()()()()(al)", "Gooooal"),
                Arguments.of("(al)G(al)()()G", "alGalooG")
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void interpretTest(String command, String expected) {
        Assertions.assertEquals(expected, Interpret.interpret(command));
    }
}
