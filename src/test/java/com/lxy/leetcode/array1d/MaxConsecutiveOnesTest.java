package com.lxy.leetcode.array1d;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class MaxConsecutiveOnesTest {
    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of(new int[]{1, 1, 0, 1, 1, 1}, 3),
            Arguments.of(new int[]{1, 0, 1, 1, 0, 1}, 2),
            Arguments.of(new int[]{0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0}, 4),
            Arguments.of(new int[]{1, 1, 1, 1, 1, 1, 1}, 7),
            Arguments.of(new int[]{0, 0, 0, 0, 0, 0, 0, 0}, 0),
            Arguments.of(new int[]{0, 0, 0, 0, 0, 1, 0, 1}, 1),
            Arguments.of(new int[]{0, 0, 1, 1, 0, 1, 1, 1, 0, 1}, 3)
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void maxConsecutiveOnesTest(int[] numbers, int expected) {
        Assertions.assertEquals(expected, MaxConsecutiveOnes.findMaxConsecutiveOnes(numbers));
    }

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void maxConsecutiveOnesSimplifiedTest(int[] numbers, int expected) {
        Assertions.assertEquals(expected, MaxConsecutiveOnes.findMaxConsecutiveOnesSimplified(numbers));
    }
}
