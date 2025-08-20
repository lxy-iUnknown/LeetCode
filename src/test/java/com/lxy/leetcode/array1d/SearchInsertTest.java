package com.lxy.leetcode.array1d;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class SearchInsertTest {

    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of(new int[]{1, 3, 5, 6}, 5, 2),
            Arguments.of(new int[]{1, 3, 5, 6}, 2, 1),
            Arguments.of(new int[]{1, 3, 5, 6}, 7, 4),
            Arguments.of(new int[]{1, 3, 4, 7, 8, 9, 11, 13, 17}, 4, 2),
            Arguments.of(new int[]{1, 3, 4, 7, 8, 9, 11, 13, 17}, 11, 6),
            Arguments.of(new int[]{1, 3, 4, 7, 8, 9, 11, 13, 17}, 1, 0),
            Arguments.of(new int[]{1, 3, 4, 7, 8, 9, 11, 13, 17}, 17, 8),
            Arguments.of(new int[]{1, 3, 4, 7, 8, 9, 11, 13, 17}, 10, 6),
            Arguments.of(new int[]{1, 3, 4, 7, 8, 9, 11, 13, 17}, 5, 3),
            Arguments.of(new int[]{1, 3, 4, 7, 8, 9, 11, 13, 17}, 21, 9),
            Arguments.of(new int[]{1, 3, 4, 7, 8, 9, 11, 13, 17}, -3, 0)
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void searchInsert(int[] numbers, int target, int index) {
        Assertions.assertEquals(index, SearchInsert.searchInsert(numbers, target));
    }

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void searchInsertNonRecursive(int[] numbers, int target, int index) {
        Assertions.assertEquals(index, SearchInsert.searchInsertNonRecursive(numbers, target));
    }
}
