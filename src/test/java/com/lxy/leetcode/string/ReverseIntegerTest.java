package com.lxy.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class ReverseIntegerTest {

    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of(123456, 654321),
            Arguments.of(12345, 54321),
            Arguments.of(-1234567, -7654321),
            Arguments.of(9999999, 9999999),
            Arguments.of(123454321, 123454321),
            Arguments.of(10000, 1),
            Arguments.of(-10001, -10001),
            Arguments.of(10040, 4001),
            Arguments.of(0, 0),
            Arguments.of(214748364, 463847412),
            Arguments.of(-2147483641, -1463847412),
            Arguments.of(-2147483648, 0),
            Arguments.of(2147483647, 0)
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void reverseIntegerTest(int number, int expected) {
        Assertions.assertEquals(expected, ReverseInteger.reverseInteger(number));
    }

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void reverseIntegerOptimizedTest(int number, int expected) {
        Assertions.assertEquals(expected, ReverseInteger.reverseIntegerOptimized(number));
    }
}
