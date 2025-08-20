package com.lxy.leetcode.simulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

import java.util.List;

public class MinimumTimeDifferenceTest {
    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of(List.of("23:59", "00:00"), 1),
            Arguments.of(List.of("00:00", "23:59", "00:00"), 0),
            Arguments.of(List.of("00:00", "23:59", "23:57"), 1),
            Arguments.of(List.of("00:00", "23:54", "23:54"), 0),
            Arguments.of(List.of("00:00", "23:55", "23:52", "00:10"), 3),
            Arguments.of(List.of("23:59", "23:55", "23:52", "00:01"), 2)
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void findMinDifferenceTest(List<String> timePoints, int expected) {
        Assertions.assertEquals(expected, MinimumTimeDifference.findMinDifference(timePoints));
    }
}
