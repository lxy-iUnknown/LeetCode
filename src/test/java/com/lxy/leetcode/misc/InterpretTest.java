package com.lxy.leetcode.misc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class InterpretTest {
    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of("G()(al)", "Goal"),
            Arguments.of("G()()()()(al)", "Gooooal"),
            Arguments.of("(al)G(al)()()G", "alGalooG")
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void interpretTest(String command, String expected) {
        Assertions.assertEquals(expected, Interpret.interpret(command));
    }
}
