package com.lxy.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.FieldSource;

public class ToHexTest {
    public static final int[] ARGUMENTS = {
            0, // Special case
            0xf, 0xfe, 0xfed, 0xfedc, 0xfedcb, 0xfedcba, 0xfedcba9, 0xfedcba98
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void toHexTest(int number) {
        Assertions.assertEquals(Integer.toHexString(number), ToHex.toHex(number));
    }
}
