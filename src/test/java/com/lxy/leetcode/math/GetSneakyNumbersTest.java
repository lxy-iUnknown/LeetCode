package com.lxy.leetcode.math;

import com.lxy.leetcode.util.RandomUtil;
import com.lxy.leetcode.util.TwoSet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

import java.util.stream.IntStream;

public class GetSneakyNumbersTest {

    public static final Arguments[] ARGUMENTS = IntStream.rangeClosed(2, 100)
            .mapToObj(n -> {
                var num1 = RandomUtil.randomIntClosed(0, n - 2);
                var num2 = RandomUtil.randomIntClosed(num1 + 1, n - 1);
                var array = new int[n + 2];
                for (var i = 0; i < n; i++) {
                    array[i] = i;
                }
                array[n] = num1;
                array[n + 1] = num2;
                return Arguments.of(array, TwoSet.of(num1, num2));
            })
            .toArray(Arguments[]::new);

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void getSneakyNumbersTest(int[] numbers, TwoSet<Integer> expected) {
        var actual = GetSneakyNumbers.getSneakyNumbers(numbers);
        Assertions.assertEquals(expected, new TwoSet<>(actual[0], actual[1]));
    }
}
