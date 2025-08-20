package com.lxy.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class ConvertToTitleTest {
    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of(1, "A"),
            Arguments.of(25, "Y"),
            Arguments.of(26, "Z"),
            Arguments.of(28, "AB"),
            Arguments.of(52, "AZ"),
            Arguments.of(676, "YZ"),
            Arguments.of(701, "ZY"),
            Arguments.of(702, "ZZ"),
            Arguments.of(703, "AAA"),
            Arguments.of(2147483647, "FXSHRXW")
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void convertToTitleTest(int columnNumber, String expected) {
        Assertions.assertEquals(expected, ConvertToTitle.convertToTitle(columnNumber));
    }

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void convertToTitleOptimizedTest(int columnNumber, String expected) {
        Assertions.assertEquals(expected, ConvertToTitle.convertToTitleOptimized(columnNumber));
    }
}
