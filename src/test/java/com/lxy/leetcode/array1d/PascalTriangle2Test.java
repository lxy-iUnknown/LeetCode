package com.lxy.leetcode.array1d;

import com.lxy.leetcode.util.TestUtil;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

import java.util.List;

public class PascalTriangle2Test {

    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of(0, PascalTriangles.PASCAL_1),
            Arguments.of(1, PascalTriangles.PASCAL_2),
            Arguments.of(2, PascalTriangles.PASCAL_3),
            Arguments.of(3, PascalTriangles.PASCAL_4),
            Arguments.of(4, PascalTriangles.PASCAL_5),
            Arguments.of(5, PascalTriangles.PASCAL_6),
            Arguments.of(6, PascalTriangles.PASCAL_7),
            Arguments.of(7, PascalTriangles.PASCAL_8),
            Arguments.of(8, PascalTriangles.PASCAL_9),
            Arguments.of(9, PascalTriangles.PASCAL_10)
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void pascalTriangleTest(int n, List<Integer> expected) {
        TestUtil.assertListEquals(expected, PascalTriangle2.pascalTriangle2(n));
    }

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void pascalTriangleTestOptimized(int n, List<Integer> expected) {
        TestUtil.assertListEquals(expected, PascalTriangle2.pascalTriangle2Optimized(n));
    }
}
