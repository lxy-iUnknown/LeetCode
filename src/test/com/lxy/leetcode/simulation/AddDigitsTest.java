package com.lxy.leetcode.simulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;

public class AddDigitsTest {

    private static int addDigits(int number) {
        while (number >= 10) {
            int sum = 0;
            while (number > 0) {
                int temp = number / 10;
                sum += number - temp * 10;
                number = temp;
            }
            number = sum;
        }
        return number;
    }

    public static IntStream arguments() {
        return IntStream.rangeClosed(0, 200);
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void addDigitsTest(int number) {
        Assertions.assertEquals(addDigits(number), AddDigits.addDigits(number));
    }
}
