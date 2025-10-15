package com.lxy.leetcode.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

import java.math.BigInteger;
import java.util.stream.Stream;

public class AddStringsTest {
    public static final Arguments[] ARGUMENTS;

    static {
        var gen = new BigNumGenerator(BigInteger::add);
        var stream = Stream.concat(gen.generate(100, 100), gen.generate(200, 40));
        ARGUMENTS = stream.toArray(Arguments[]::new);
    }

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void addStringsTest(String num1, String num2, String expected) {
        Assertions.assertEquals(expected, AddStrings.addStrings(num1, num2));
    }
}
