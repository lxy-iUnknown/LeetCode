package com.lxy.leetcode.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

import java.math.BigInteger;
import java.util.stream.Stream;

public class AddBinaryTest {
    public static final Arguments[] ARGUMENTS;

    static {
        var gen = new BigNumGenerator(BigInteger::add, 2);
        var stream = Stream.concat(gen.generate(50, 50), gen.generate(100, 20));
        ARGUMENTS = stream.toArray(Arguments[]::new);
    }

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void addBinaryTest(String a, String b, String expected) {
        Assertions.assertEquals(expected, AddBinary.addBinary(a, b));
    }
}
