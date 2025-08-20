package com.lxy.leetcode.misc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class XorOperationTest {
    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of(5, 0, 8), Arguments.of(4, 3, 8),
            Arguments.of(1, 7, 7), Arguments.of(10, 5, 2)
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void xorOperationTest(int n, int start, int expected) {
        Assertions.assertEquals(expected, XorOperation.xorOperation(n, start));
    }

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void xorOperationOptimizedTest(int n, int start, int expected) {
        Assertions.assertEquals(expected, XorOperation.xorOperationOptimized(n, start));
    }
}
