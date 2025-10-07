package com.lxy.leetcode.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class MaximumProductTest {
    public static final Arguments[] ARGUMENTS = {
            Arguments.of(new int[]{-1, 2, 3}, -1 * 2 * 3),

            Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, 4 * 5 * 6),
            Arguments.of(new int[]{-6, -5, -4, -3, -2, -1}, -1 * -2 * -3),

            Arguments.of(new int[]{-6, -4, -2, 0, 0, 1, 10, 15, 20}, 10 * 15 * 20),
            Arguments.of(new int[]{-6, -4, -2, 0, 0, 1, 2, 4, 5}, 5 * -6 * -4),

            Arguments.of(new int[]{-6, -4, 0, 0, 0, 1, 10, 15, 20}, 10 * 15 * 20),
            Arguments.of(new int[]{-6, 0, 0, 0, 0, 1, 10, 15, 20}, 10 * 15 * 20),

            Arguments.of(new int[]{-6, -4, -2, 0, 0, 1, 2}, 2 * -6 * -4),
            Arguments.of(new int[]{-6, -4, 0, 0, 0, 1, 2}, 2 * -6 * -4),
            Arguments.of(new int[]{-6, 0, 0, 0, 0, 1, 2}, 0),

            Arguments.of(new int[]{-6, -4, -2, 0, 0, 2}, 2 * -6 * -4),
            Arguments.of(new int[]{-6, -4, 0, 0, 0, 2}, 2 * -6 * -4),
            Arguments.of(new int[]{-6, 0, 0, 0, 0, 2}, 0),
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void maximumProductTest(int[] nums, int expected) {
        Assertions.assertEquals(expected, MaximumProduct.maximumProduct(nums));
    }
}
