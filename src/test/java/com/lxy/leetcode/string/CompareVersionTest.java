package com.lxy.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class CompareVersionTest {
    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of("1.1", "1.0001", 0),
            Arguments.of("000001.00012", "0001.00012", 0),
            Arguments.of("123.145", "123.145.00.00", 0),
            Arguments.of("123.145.0000.00.00", "123.145", 0),
            Arguments.of("00002.001.3.4.5678", "2.01.00003.0004.000000005678", 0),
            Arguments.of("002.001.003.4.5678.99", "2.1.00003.004.0000005678.0099", 0),
            Arguments.of("123.145", "123.145", 0),
            Arguments.of("123.145", "123.145.11", -1),
            Arguments.of("123.145.2233", "123.145.11", 1),
            Arguments.of("002.001.003.4.5678.99", "2.1.00003.004.0000005678.0098", 1),
            Arguments.of("002.001.003.4.5678.97", "2.1.00003.004.0000005678.0098", -1),
            Arguments.of("002.001.003.4.5678.99", "2.1.00003.003.0000005678.0099", 1),
            Arguments.of("002.001.003.4.5678.97", "2.1.00003.005.0000005678.0099", -1),
            Arguments.of("002.001.003.4.5678.99", "2.0.00003.005.0000005678.0099", 1),
            Arguments.of("002.001.003.4.5678.97", "2.2.00003.003.0000005678.0099", -1),
            Arguments.of("002.001.003.4.5678.99", "1.1.00003.004.0000005678.0099", 1),
            Arguments.of("002.001.003.4.5678.99", "3.1.00003.004.0000005678.0099", -1),
            Arguments.of("002.001.003.4.5678.99", "2.0.009999.004.0000005678.9999", 1),
            Arguments.of("002.001.003.4.5678.99", "2.2.001.004.0000005678.9999", -1)
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void compareVersionTest(String version1, String version2, int expected) {
        Assertions.assertEquals(expected, CompareVersion.compareVersion(version1, version2));
    }
}
