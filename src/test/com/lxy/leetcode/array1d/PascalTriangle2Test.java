package com.lxy.leetcode.array1d;

import com.lxy.leetcode.util.TestUtil;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class PascalTriangle2Test {

    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(0, Constants.PASCAL_1),
                Arguments.of(1, Constants.PASCAL_2),
                Arguments.of(2, Constants.PASCAL_3),
                Arguments.of(3, Constants.PASCAL_4),
                Arguments.of(4, Constants.PASCAL_5),
                Arguments.of(5, Constants.PASCAL_6),
                Arguments.of(6, Constants.PASCAL_7),
                Arguments.of(7, Constants.PASCAL_8),
                Arguments.of(8, Constants.PASCAL_9),
                Arguments.of(9, Constants.PASCAL_10)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void pascalTriangleTest(int n, List<Integer> expected) {
        TestUtil.assertListEquals(expected, PascalTriangle2.pascalTriangle2(n));
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void pascalTriangleTestOptimized(int n, List<Integer> expected) {
        TestUtil.assertListEquals(expected, PascalTriangle2.pascalTriangle2Optimized(n));
    }
}
