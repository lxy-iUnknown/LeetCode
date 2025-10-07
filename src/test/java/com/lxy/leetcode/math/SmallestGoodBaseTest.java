package com.lxy.leetcode.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class SmallestGoodBaseTest {
    public static final Arguments[] ARGUMENTS = {
            Arguments.of(13L, 3L),
            Arguments.of(4681L, 8L),
            Arguments.of(9999L, 9998L),
            Arguments.of(469070941L, 12L),
            Arguments.of(76861433640456465L, 16L),
            Arguments.of(157946044610720563L, 6L),
            Arguments.of(3533808746164949071L, 1234L),
            Arguments.of(23227344339325621L, 12345L),
            Arguments.of(1000000000000000000L, 999999999999999999L),
            Arguments.of(9223372036854775807L, 2L),
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void smallestGoodBaseTest(long n, long result) {
        Assertions.assertEquals(result, SmallestGoodBase.smallestGoodBase(n));
    }
}
