package com.lxy.leetcode.simulation;

import com.lxy.leetcode.util.TestUtil;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CalculateTaxTest {
    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[][]{
                        new int[]{3, 50},
                        new int[]{7, 10},
                        new int[]{12, 25}
                }, 10, 2.65),
                Arguments.of(new int[][]{
                        new int[]{1, 0},
                        new int[]{4, 25},
                        new int[]{5, 50}
                }, 2, 0.25),
                Arguments.of(new int[][]{
                        new int[]{1, 1},
                        new int[]{4, 5},
                        new int[]{10, 10},
                        new int[]{20, 20},
                        new int[]{50, 40},
                        new int[]{100, 70},
                }, 100, 49.76),
                Arguments.of(new int[][]{
                        new int[]{2, 50},
                        new int[]{3, 40}
                }, 0, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void calculateTaxTest(int[][] brackets, int income, double expected) {
        TestUtil.assertFuzzyEquals(expected, CalculateTax.calculateTax(brackets, income), 1e-5);
    }
}
