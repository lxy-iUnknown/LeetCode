package com.lxy.leetcode.dp;

import com.lxy.leetcode.util.Constants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumWaysTest {
    private static int numWays(int n) {
        switch (n) {
            case 0, 1 -> {
                return 1;
            }
            default -> {
                BigInteger dp_1 = BigInteger.ONE;
                BigInteger dp_2 = BigInteger.ONE;
                for (int i = 2; i <= n; i++) {
                    BigInteger dp = dp_1.add(dp_2);
                    dp_1 = dp_2;
                    dp_2 = dp;
                }
                return dp_2.mod(Constants.MODULO_BIG_INTEGER).intValueExact();
            }
        }
    }

    public static IntStream arguments() {
        return IntStream.rangeClosed(0, 100);
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void numWaysTest(int n) {
        Assertions.assertEquals(numWays(n), NumWays.numWays(n));
    }
}
