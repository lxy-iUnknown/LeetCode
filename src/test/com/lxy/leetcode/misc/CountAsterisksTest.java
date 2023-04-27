package com.lxy.leetcode.misc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CountAsterisksTest {
    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of("l|*e*et|c**o|*de|", 2),
                Arguments.of("iamprogrammer", 0),
                Arguments.of("yo|uar|e**|b|e**6*au|tifu|l", 5),
                Arguments.of("*y*o|uar|e**|b|e**6*au|tifu|l****", 11),
                Arguments.of("yyyaaa**abc*ccdeimpd****", 7),
                Arguments.of("yyyaaa**a||bc*ccdeim|pd**9*9|*", 4),
                Arguments.of("yyya||**||**5*6", 5)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void countAsterisksTest(String s, int expected) {
        Assertions.assertEquals(expected, CountAsterisks.countAsterisks(s));
    }
}
