package com.lxy.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class ToHexTest {
    public static int[] arguments() {
        return new int[]{
                0, // Special case
                0xf, 0xfe, 0xfed, 0xfedc, 0xfedcb, 0xfedcba, 0xfedcba9, 0xfedcba98
        };
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void toHexTest(int number) {
        Assertions.assertEquals(Integer.toHexString(number), ToHex.toHex(number));
    }
}
