package com.lxy.leetcode.array1d;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MergeIntervalsTest {

    public static Stream<Arguments> arguments() {
        return Stream.of(
                // Sorted arguments
                Arguments.of(new int[][]{
                        new int[]{1, 4}, new int[]{5, 6},
                }, new int[][]{
                        new int[]{1, 4}, new int[]{5, 6},
                }),
                Arguments.of(new int[][]{
                        new int[]{1, 3}, new int[]{4, 6}, new int[]{8, 10}, new int[]{15, 18}, new int[]{19, 23}
                }, new int[][]{
                        new int[]{1, 3}, new int[]{4, 6}, new int[]{8, 10}, new int[]{15, 18}, new int[]{19, 23}
                }),
                Arguments.of(new int[][]{
                        new int[]{1, 3}, new int[]{2, 6}, new int[]{8, 10}, new int[]{15, 18}
                }, new int[][]{
                        new int[]{1, 6}, new int[]{8, 10}, new int[]{15, 18}
                }),
                Arguments.of(new int[][]{
                        new int[]{1, 4}, new int[]{4, 5},
                }, new int[][]{
                        new int[]{1, 5}
                }),
                Arguments.of(new int[][]{
                        new int[]{1, 3}, new int[]{2, 6}, new int[]{4, 10}, new int[]{6, 18}
                }, new int[][]{
                        new int[]{1, 18}
                }),
                Arguments.of(new int[][]{
                        new int[]{1, 4}
                }, new int[][]{
                        new int[]{1, 4}
                }),
                Arguments.of(new int[][]{
                        new int[]{1, 1}
                }, new int[][]{
                        new int[]{1, 1}
                }),
                // Unsorted arguments
                // Note: Expected intervals MUST be sorted!!!
                Arguments.of(new int[][]{
                        new int[]{17, 19}, new int[]{1, 3}, new int[]{12, 12}, new int[]{8, 10},
                        new int[]{6, 7}, new int[]{14, 16}, new int[]{4, 5}, new int[]{20, 22}
                }, new int[][]{
                        new int[]{1, 3}, new int[]{4, 5}, new int[]{6, 7}, new int[]{8, 10},
                        new int[]{12, 12}, new int[]{14, 16}, new int[]{17, 19}, new int[]{20, 22}
                }),
                Arguments.of(new int[][]{
                        new int[]{17, 19}, new int[]{1, 3}, new int[]{12, 12}, new int[]{8, 10},
                        new int[]{4, 6}, new int[]{14, 16}, new int[]{2, 7}, new int[]{18, 22}
                }, new int[][]{
                        new int[]{1, 7}, new int[]{8, 10}, new int[]{12, 12}, new int[]{14, 16},
                        new int[]{17, 22}
                }),
                Arguments.of(new int[][]{
                        new int[]{8, 20}, new int[]{6, 18}, new int[]{1, 3}, new int[]{4, 10},
                        new int[]{2, 6}
                }, new int[][]{
                        new int[]{1, 20}
                })
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void mergeIntervals(int[][] intervals, int[][] result) {
        Assertions.assertArrayEquals(result, MergeIntervals.merge(intervals));
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void mergeIntervalsOptimized(int[][] intervals, int[][] result) {
        Assertions.assertArrayEquals(result, MergeIntervals.mergeOptimized(intervals));
    }
}
