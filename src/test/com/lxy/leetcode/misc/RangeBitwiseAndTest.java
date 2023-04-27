package com.lxy.leetcode.misc;

import com.lxy.leetcode.util.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class RangeBitwiseAndTest {

    private static final int MAX_START = 1000;
    private static final int MAX_STEP = Integer.MAX_VALUE - MAX_START;
    private static final int ITERATIONS = 100;

    private static int rangeBitwiseAnd(int left, int right) {
        int result = left;
        for (int i = left + 1; i <= right && i >= 0; /* prevent integer overflow */ i++) {
            result &= i;
            if (result == 0) {
                break;
            }
        }
        return result;
    }

    public static Stream<Arguments> arguments() {
        return Stream.generate(() -> {
            int left = Util.randomIntClosed(MAX_START);
            int step = Util.randomIntClosed(MAX_STEP);
            return Arguments.of(left, left + step);
        }).limit(ITERATIONS);
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void rangeBitwiseAndTest(int left, int right) {
        Assertions.assertEquals(rangeBitwiseAnd(left, right),
                RangeBitwiseOperations.bitwiseAnd(left, right));
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void rangeBitwiseAndBrianKernighanTest(int left, int right) {
        Assertions.assertEquals(rangeBitwiseAnd(left, right),
                RangeBitwiseOperations.bitwiseAndBrianKernighan(left, right));
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void rangeBitwiseAndBrianOptimizedTest(int left, int right) {
        Assertions.assertEquals(rangeBitwiseAnd(left, right),
                RangeBitwiseOperations.bitwiseAndOptimized(left, right));
    }
}
