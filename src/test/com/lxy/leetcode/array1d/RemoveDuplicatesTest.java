package com.lxy.leetcode.array1d;

import com.lxy.leetcode.util.TestUtil;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class RemoveDuplicatesTest {

    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 2}, new int[]{1, 2}, 2),
                Arguments.of(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}, new int[]{0, 1, 2, 3, 4}, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void removeDuplicates(int[] numbers, int[] expected, int actualLength) {
        TestUtil.assertArrayEquals(expected, numbers, RemoveDuplicates.removeDuplicates(numbers));
    }
}
