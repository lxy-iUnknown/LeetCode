package com.lxy.leetcode.simulation;

import com.lxy.leetcode.util.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.FieldSource;

import java.util.List;

public class AddDigitsTest {
    public static final List<Integer> ARGUMENTS = TestUtil.generateRangeArray(0, 200);

    private static int addDigits(int number) {
        while (number >= 10) {
            var sum = 0;
            while (number > 0) {
                var temp = number / 10;
                sum += number - temp * 10;
                number = temp;
            }
            number = sum;
        }
        return number;
    }

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void addDigitsTest(int number) {
        Assertions.assertEquals(addDigits(number), AddDigits.addDigits(number));
    }
}
