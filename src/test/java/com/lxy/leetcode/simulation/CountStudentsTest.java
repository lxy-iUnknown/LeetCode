package com.lxy.leetcode.simulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class CountStudentsTest {
    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of(new int[]{1, 1, 0, 0},
                    new int[]{0, 1, 0, 1}, 0),
            Arguments.of(new int[]{1, 1, 1, 0, 0, 1},
                    new int[]{1, 0, 0, 0, 1, 1}, 3),
            Arguments.of(new int[]{1, 1, 1, 1, 1, 1},
                    new int[]{0, 0, 0, 0, 0, 0}, 6),
            Arguments.of(new int[]{0, 0, 0, 1, 1, 1, 1, 0, 0, 0},
                    new int[]{1, 0, 1, 0, 0, 1, 1, 0, 0, 0}, 0)
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void countStudentsTest(int[] students, int[] sandwiches, int expected) {
        Assertions.assertEquals(expected, CountStudents.countStudents(students, sandwiches));
    }

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void countStudentsOptimizedTest(int[] students, int[] sandwiches, int expected) {
        Assertions.assertEquals(expected, CountStudents.countStudentsOptimized(students, sandwiches));
    }
}
