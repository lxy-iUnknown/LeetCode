package com.lxy.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class LicenseKeyFormattingTest {
    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of("5F3Z-2e-9-w", 4, "5F3Z-2E9W"),
            Arguments.of("2-5g-3-J", 2, "2-5G-3J"),
            Arguments.of("45Gb-M1-f-3-hk5-9p", 4, "4-5GBM-1F3H-K59P"),
            Arguments.of("45Gb-M1-f-3-hk5-9p", 5, "45G-BM1F3-HK59P"),
            Arguments.of("45Gb-M1-f-3-hk5-9p", 6, "4-5GBM1F-3HK59P"),
            Arguments.of("45Gb-M1-f-3-hk5-9p", 100, "45GBM1F3HK59P"),
            Arguments.of("2-5g-3-J", 1, "2-5-G-3-J"),
            Arguments.of("5F3Z2e9w", 1, "5-F-3-Z-2-E-9-W"),
            Arguments.of("5F3Z-2e-9-w", 1, "5-F-3-Z-2-E-9-W"),
            Arguments.of("--d-c-b-a--", 2, "DC-BA"),
            Arguments.of("----d--c--b---a----", 1, "D-C-B-A"),
            Arguments.of("----d--c--b---a----", 2, "DC-BA"),
            Arguments.of("----d--c--b---a----", 3, "D-CBA"),
            Arguments.of("----f-e--d--c--b---a----", 3, "FED-CBA"),
            Arguments.of("----f-e--d--c--b---a----", 5, "F-EDCBA")
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void licenseKeyFormattingTest(String s, int k, String expected) {
        Assertions.assertEquals(expected, LicenseKeyFormatting.licenseKeyFormatting(s, k));
    }
}
