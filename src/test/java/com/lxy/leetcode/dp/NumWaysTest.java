package com.lxy.leetcode.dp;

import com.lxy.leetcode.util.Constants;
import com.lxy.leetcode.util.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.FieldSource;

import java.math.BigInteger;
import java.util.List;

public class NumWaysTest {
    public static final List<Integer> ARGUMENTS = TestUtil.generateRangeArray(0, 100);

    private static int numWays(int n) {
        switch (n) {
            case 0, 1 -> {
                return 1;
            }
            default -> {
                BigInteger dp_1 = BigInteger.ONE;
                BigInteger dp_2 = BigInteger.ONE;
                for (var i = 2; i <= n; i++) {
                    var dp = dp_1.add(dp_2);
                    dp_1 = dp_2;
                    dp_2 = dp;
                }
                return dp_2.mod(Constants.MODULO_BIG_INTEGER).intValueExact();
            }
        }
    }

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void numWaysTest(int n) {
        Assertions.assertEquals(numWays(n), NumWays.numWays(n));
    }
}
