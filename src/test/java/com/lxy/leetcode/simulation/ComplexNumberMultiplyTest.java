package com.lxy.leetcode.simulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class ComplexNumberMultiplyTest {
    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of("1+1i", "1+1i", "0+2i"),
            Arguments.of("1+-1i", "1+-1i", "0+-2i"),
            Arguments.of("3+-2i", "1+-4i", "-5+-14i"),
            Arguments.of("13+-72i", "-21+94i", "6495+2734i")
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void complexNumberMultiplyTest(String number1, String number2, String expected) {
        Assertions.assertEquals(expected, ComplexNumberMultiply.complexNumberMultiply(number1, number2));
    }
}
