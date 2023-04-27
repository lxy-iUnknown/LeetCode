package com.lxy.leetcode.array1d;

import com.lxy.leetcode.util.TestUtil;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class PascalTriangleTest {

    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(1, List.of(Constants.PASCAL_1)),
                Arguments.of(2, List.of(Constants.PASCAL_1, Constants.PASCAL_2)),
                Arguments.of(3, List.of(
                        Constants.PASCAL_1, Constants.PASCAL_2, Constants.PASCAL_3)),
                Arguments.of(4, List.of(
                        Constants.PASCAL_1, Constants.PASCAL_2, Constants.PASCAL_3,
                        Constants.PASCAL_4)),
                Arguments.of(5, List.of(
                        Constants.PASCAL_1, Constants.PASCAL_2, Constants.PASCAL_3,
                        Constants.PASCAL_4, Constants.PASCAL_5)),
                Arguments.of(6,
                        List.of(Constants.PASCAL_1, Constants.PASCAL_2, Constants.PASCAL_3,
                                Constants.PASCAL_4, Constants.PASCAL_5, Constants.PASCAL_6)),
                Arguments.of(7,
                        List.of(Constants.PASCAL_1, Constants.PASCAL_2, Constants.PASCAL_3,
                                Constants.PASCAL_4, Constants.PASCAL_5, Constants.PASCAL_6,
                                Constants.PASCAL_7)),
                Arguments.of(8,
                        List.of(Constants.PASCAL_1, Constants.PASCAL_2, Constants.PASCAL_3,
                                Constants.PASCAL_4, Constants.PASCAL_5, Constants.PASCAL_6,
                                Constants.PASCAL_7, Constants.PASCAL_8)),
                Arguments.of(9,
                        List.of(Constants.PASCAL_1, Constants.PASCAL_2, Constants.PASCAL_3,
                                Constants.PASCAL_4, Constants.PASCAL_5, Constants.PASCAL_6,
                                Constants.PASCAL_7, Constants.PASCAL_8, Constants.PASCAL_9)),
                Arguments.of(10,
                        List.of(Constants.PASCAL_1, Constants.PASCAL_2, Constants.PASCAL_3,
                                Constants.PASCAL_4, Constants.PASCAL_5, Constants.PASCAL_6,
                                Constants.PASCAL_7, Constants.PASCAL_8, Constants.PASCAL_9,
                                Constants.PASCAL_10))
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void pascalTriangleTest(int n, List<List<Integer>> expected) {
        TestUtil.assertDoubleListEquals(expected, PascalTriangle.pascalTriangle(n));
    }
}
