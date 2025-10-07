package com.lxy.leetcode.math;

import com.lxy.leetcode.util.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.FieldSource;

import java.util.List;

public class CountNumbersWithUniqueDigitsTest {
    public static final List<Integer> ARGUMENTS = TestUtil.generateRangeArray(0, 10);

    private static int countNumbersFunc(int n) {
        var perm = 1;
        var value = 9;
        for (var i = 0; i < n - 1; i++) {
            perm *= value;
            value--;
        }
        return 9 * perm;
    }

    private static int countNumbersWithUniqueDigits(int n) {
        var sum = 1;
        for (var i = 1; i <= n; i++) {
            sum += countNumbersFunc(i);
        }
        return sum;
    }

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void countNumbersWithUniqueDigitsTest(int n) {
        Assertions.assertEquals(
                CountNumbersWithUniqueDigits.countNumbersWithUniqueDigits(n),
                countNumbersWithUniqueDigits(n)
        );
    }

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void countNumbersWithUniqueDigitsTableTest(int n) {
        Assertions.assertEquals(
                CountNumbersWithUniqueDigits.countNumbersWithUniqueDigitsTable(n),
                countNumbersWithUniqueDigits(n)
        );
    }
}
