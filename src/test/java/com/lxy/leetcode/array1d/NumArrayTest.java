package com.lxy.leetcode.array1d;

import com.lxy.leetcode.util.RandomUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

import java.util.Arrays;
import java.util.stream.Stream;

public class NumArrayTest {
    private static final int MAX_ARRAY_ABSOLUTE_VALUE = 100000;
    private static final int MIN_ARRAY_SIZE = 100;
    private static final int MAX_ARRAY_SIZE = 10000;
    private static final int RANDOM_ITERATION_COUNT = 10;
    private static final int ITERATION_COUNT = 20;

    private static final ISumRangeFactory DEFAULT_FACTORY = numbers ->
            (left, right) -> {
                var sum = 0;
                for (var i = left; i <= right; i++) {
                    sum += numbers[i];
                }
                return sum;
            };

    private static final ISumRangeFactory[] TEST_FACTORIES = {
            numbers -> new NumArray(numbers)::sumRange,
            numbers -> new NumArraySimple(numbers)::sumRange
    };
    public static final Arguments[] ARGUMENTS =
            Stream.generate(NumArrayTest::randomArray)
                    .limit(RANDOM_ITERATION_COUNT)
                    .flatMap(numbers -> {
                        var length = numbers.length;
                        var expected = DEFAULT_FACTORY.create(numbers);
                        return Arrays.stream(TEST_FACTORIES)
                                .flatMap(factory -> {
                                    var actual = factory.create(numbers);
                                    return Stream.generate(() -> {
                                        var left = RandomUtil.randomInt(length);
                                        var right = RandomUtil.randomInt(left, length);
                                        return Arguments.of(expected, actual, left, right);
                                    }).limit(ITERATION_COUNT);
                                });
                    }).toArray(Arguments[]::new);

    private static int[] randomArray() {
        var size = RandomUtil.randomIntClosed(MIN_ARRAY_SIZE, MAX_ARRAY_SIZE);
        var array = new int[size];
        for (var i = 0; i < size; i++) {
            array[i] = RandomUtil.randomIntClosed(-MAX_ARRAY_ABSOLUTE_VALUE, MAX_ARRAY_ABSOLUTE_VALUE);
        }
        return array;
    }

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void numArrayTest(ISumRange expected, ISumRange actual, int left, int right) {
        Assertions.assertEquals(expected.apply(left, right), actual.apply(left, right));
    }
}
