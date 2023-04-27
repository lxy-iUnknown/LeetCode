package com.lxy.leetcode.array1d;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class RotateArrayTest {
    /**
     * <a href="https://leetcode.cn/submissions/detail/397766423/">第一组测试数据来源</a>
     */
    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{1, 2}, 3, new int[]{2, 1}),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7}, 3, new int[]{5, 6, 7, 1, 2, 3, 4}),
                Arguments.of(new int[]{-1, -100, 3, 99}, 2, new int[]{3, 99, -1, -100}),
                Arguments.of(new int[]{3, 4, 7, 1, 0, 4, 5, 8, 10, 2}, 7, new int[]{1, 0, 4, 5, 8, 10, 2, 3, 4, 7})
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void rotateArray(int[] numbers, int k, int[] result) {
        RotateArray.rotate(numbers, k);
        Assertions.assertArrayEquals(result, numbers);
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void rotateArrayReverse(int[] numbers, int k, int[] result) {
        RotateArray.rotateReverse(numbers, k);
        Assertions.assertArrayEquals(result, numbers);
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void rotateArrayCircularReplace(int[] numbers, int k, int[] result) {
        RotateArray.rotateCircularReplace(numbers, k);
        Assertions.assertArrayEquals(result, numbers);
    }
}
