package com.lxy.leetcode.array1d;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class TwoSumTest {
    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}),
            Arguments.of(new int[]{3, 2, 4}, 6, new int[]{1, 2}),
            Arguments.of(new int[]{3, 3}, 6, new int[]{0, 1}),
            Arguments.of(new int[]{4, 0, 3, 1, 5, 7, 13, 2}, 12, new int[]{4, 5})
    };

    public static int[] normalize(int[] indices) {
        if (indices == null) {
            return null;
        }
        var first = indices[0];
        var second = indices[1];
        if (first > second) {
            indices[0] = second;
            indices[1] = first;
        }
        return indices;
    }

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void twoSumTest(int[] numbers, int target, int[] expected) {
        Assertions.assertArrayEquals(expected, normalize(TwoSum.twoSum(numbers, target)));
    }

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void twoSumHashMapTest(int[] numbers, int target, int[] expected) {
        Assertions.assertArrayEquals(expected, normalize(TwoSum.twoSumHashMap(numbers, target)));
    }
}
