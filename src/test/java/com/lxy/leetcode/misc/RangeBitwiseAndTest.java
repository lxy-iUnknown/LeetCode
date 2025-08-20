package com.lxy.leetcode.misc;

import com.lxy.leetcode.util.RandomUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

import java.util.stream.Stream;

public class RangeBitwiseAndTest {

    private static final int MAX_START = 1000;
    private static final int MAX_STEP = Integer.MAX_VALUE - MAX_START;

    public static final Arguments[] ARGUMENTS = Stream
            .generate(() -> {
                var left = RandomUtil.randomIntClosed(MAX_START);
                var step = RandomUtil.randomIntClosed(MAX_STEP);
                return Arguments.of(left, left + step);
            })
            .limit(100)
            .toArray(Arguments[]::new);

    private static int rangeBitwiseAnd(int left, int right) {
        var result = left;
        for (var i = left + 1; i <= right && i >= 0; /* prevent integer overflow */ i++) {
            result &= i;
            if (result == 0) {
                break;
            }
        }
        return result;
    }

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void rangeBitwiseAndTest(int left, int right) {
        Assertions.assertEquals(rangeBitwiseAnd(left, right),
                RangeBitwiseOperations.bitwiseAnd(left, right));
    }

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void rangeBitwiseAndBrianKernighanTest(int left, int right) {
        Assertions.assertEquals(rangeBitwiseAnd(left, right),
                RangeBitwiseOperations.bitwiseAndBrianKernighan(left, right));
    }

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void rangeBitwiseAndBrianOptimizedTest(int left, int right) {
        Assertions.assertEquals(rangeBitwiseAnd(left, right),
                RangeBitwiseOperations.bitwiseAndOptimized(left, right));
    }
}
