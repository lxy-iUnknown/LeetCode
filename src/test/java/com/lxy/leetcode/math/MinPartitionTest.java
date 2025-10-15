package com.lxy.leetcode.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class MinPartitionTest {
    public static final Arguments[] ARGUMENTS = {
            Arguments.of("32", 3),
            Arguments.of("82734", 8),
            Arguments.of("27346209830709182346", 9)
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void minPartitionTest(String n, int expected) {
        Assertions.assertEquals(expected, MinPartitions.minPartitions(n));
    }
}
