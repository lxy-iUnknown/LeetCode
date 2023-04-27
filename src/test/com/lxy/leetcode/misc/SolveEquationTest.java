package com.lxy.leetcode.misc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolveEquationTest {
    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of("x+5-3+x=6+x-2", "x=2"),
                Arguments.of("3x=x", "x=0"),
                Arguments.of("2x-4+4x+7=15", "x=2"),
                Arguments.of("2x-4+4x+7=-3x+12", "x=1"),
                Arguments.of("2x-4+4x+7-x+3x-3=-x+27", "x=3"),
                Arguments.of("x=x", "Infinite solutions"),
                Arguments.of("2x-15+x=x-7+x+x-8", "Infinite solutions"),
                Arguments.of("2x-15+3x=-8+5x-7", "Infinite solutions"),
                Arguments.of("-9+1-7=-14-1", "Infinite solutions"),
                Arguments.of("---9+++1-7=-14---1", "Infinite solutions"),
                Arguments.of("0x=0", "Infinite solutions"),
                Arguments.of("-12-3+4=5-17+88", "No solution"),
                Arguments.of("---12-3--+4=++++5-++17--+88", "No solution"),
                Arguments.of("2x-15+x=-x-x-x", "No solution"),
                Arguments.of("2x-15+x=-x", "No solution"),
                Arguments.of("2x-17+x=-x", "No solution")
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void solveEquationTest(String equation, String expected) {
        Assertions.assertEquals(expected, SolveEquation.solveEquation(equation));
    }
}
