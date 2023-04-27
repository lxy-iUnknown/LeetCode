package com.lxy.leetcode.misc;

import com.lxy.leetcode.util.Constants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class CuttingRopeTest {
    private static final BigInteger THREE = BigInteger.valueOf(3);

    private static long powerMod3(long n) {
        return THREE.modPow(BigInteger.valueOf(n), Constants.MODULO_BIG_INTEGER).longValueExact();
    }

    private static int cuttingRope(int n) {
        // Special case
        if (n == 2) {
            return 1; // 1 * 1
        }
        if (n == 3) {
            return 2; // 1 * 2 because m > 1
        }
        int x = n / 3;
        return switch (n - x * 3) {
            case 0 -> (int) (powerMod3(x) % Constants.MODULO);
            case 1 -> (int) ((powerMod3(x - 1) * 4) % Constants.MODULO);
            default -> (int) ((powerMod3(x) * 2) % Constants.MODULO);
        };
    }

    public static IntStream arguments() {
        return IntStream.rangeClosed(2, 200);
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void cuttingRopeTest(int n) {
        Assertions.assertEquals(CuttingRope.cuttingRope(n), cuttingRope(n));
    }
}
