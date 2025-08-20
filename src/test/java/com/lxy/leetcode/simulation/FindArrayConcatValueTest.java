package com.lxy.leetcode.simulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class FindArrayConcatValueTest {
    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of(new int[]{701, 52, 0}, 7062),
            Arguments.of(new int[]{1, 52, 2}, 64),
            Arguments.of(new int[]{9999, 2, 10000}, 999910002),
            Arguments.of(new int[]{7, 52, 2, 4}, 596),
            Arguments.of(new int[]{5, 14, 13, 8, 12}, 673),
            Arguments.of(new int[]{14, 7, 132, 468, 0, 25, 6, 4}, 18125)
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void findArrayConcatValueTest(int[] numbers, long expected) {
        Assertions.assertEquals(expected, FindArrayConcatValue.findArrayConcatValue(numbers));
    }
}
