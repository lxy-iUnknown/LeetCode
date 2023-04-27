package com.lxy.leetcode.simulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class GiveGemTest {
    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{3, 1, 2},
                        new int[][]{
                                new int[]{0, 2}, new int[]{2, 1}, new int[]{2, 0}
                        }, 2),
                Arguments.of(new int[]{100, 0, 50, 100},
                        new int[][]{
                                new int[]{0, 2}, new int[]{0, 1}, new int[]{3, 0}, new int[]{3, 0},
                        }, 75),
                Arguments.of(new int[]{0, 0, 0, 0},
                        new int[][]{
                                new int[]{1, 2}, new int[]{3, 1}, new int[]{1, 2},
                        }, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void giveGemTest(int[] gem, int[][] operations, int expected) {
        Assertions.assertEquals(expected, GiveGem.giveGem(gem, operations));
    }
}
