package com.lxy.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class SortPeopleTest {
    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of(
                    new String[]{"Mary", "John", "Emma"},
                    new int[]{180, 165, 170},
                    new String[]{"Mary", "Emma", "John"}),
            Arguments.of(
                    new String[]{"Alice", "Bob", "Bob"},
                    new int[]{155, 185, 150},
                    new String[]{"Bob", "Alice", "Bob"})
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void sortPeopleTest(String[] names, int[] heights, String[] expected) {
        Assertions.assertArrayEquals(expected, SortPeople.sortPeople(names, heights));
    }
}
