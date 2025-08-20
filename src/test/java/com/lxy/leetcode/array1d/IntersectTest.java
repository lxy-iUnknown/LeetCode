package com.lxy.leetcode.array1d;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

import java.util.Arrays;

public class IntersectTest {

    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of(new int[]{1, 2, 2, 1}, new int[]{2, 2}, new int[]{2, 2}),
            Arguments.of(new int[]{1, 2, 2, 1}, new int[]{2}, new int[]{2}),
            Arguments.of(new int[]{1, 2, 2, 1, 3, 3, 3, 3, 3}, new int[]{2, 2, 3, 3, 3}, new int[]{2, 2, 3, 3, 3}),
            Arguments.of(new int[]{1, 2, 1, 3, 3, 3, 3, 3}, new int[]{2, 2, 3, 3, 3}, new int[]{2, 3, 3, 3}),
            Arguments.of(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}, new int[]{4, 9})
    };

    private static void checkResult(int[] expected, int[] actual) {
        Arrays.sort(actual);
        Assertions.assertArrayEquals(expected, actual);
    }

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void intersect(int[] numbers1, int[] numbers2, int[] expected) {
        var actual = Intersect.intersect(numbers1, numbers2);
        checkResult(expected, actual);
    }

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void intersectHashMap(int[] numbers1, int[] numbers2, int[] expected) {
        var actual = Intersect.intersectHashMap(numbers1, numbers2);
        checkResult(expected, actual);
    }
}
