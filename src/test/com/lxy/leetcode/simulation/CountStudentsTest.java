package com.lxy.leetcode.simulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CountStudentsTest {
    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 0, 0},
                        new int[]{0, 1, 0, 1}, 0),
                Arguments.of(new int[]{1, 1, 1, 0, 0, 1},
                        new int[]{1, 0, 0, 0, 1, 1}, 3),
                Arguments.of(new int[]{1, 1, 1, 1, 1, 1},
                        new int[]{0, 0, 0, 0, 0, 0}, 6),
                Arguments.of(new int[]{0, 0, 0, 1, 1, 1, 1, 0, 0, 0},
                        new int[]{1, 0, 1, 0, 0, 1, 1, 0, 0, 0}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void countStudentsTest(int[] students, int[] sandwiches, int expected) {
        Assertions.assertEquals(expected, CountStudents.countStudents(students, sandwiches));
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void countStudentsOptimizedTest(int[] students, int[] sandwiches, int expected) {
        Assertions.assertEquals(expected, CountStudents.countStudentsOptimized(students, sandwiches));
    }
}
