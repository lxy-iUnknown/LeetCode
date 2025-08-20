package com.lxy.leetcode.array1d;

import com.lxy.leetcode.util.TestUtil;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

import java.util.List;

public class PascalTriangleTest {

    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of(1, List.of(PascalTriangles.PASCAL_1)),
            Arguments.of(2, List.of(PascalTriangles.PASCAL_1, PascalTriangles.PASCAL_2)),
            Arguments.of(3, List.of(
                    PascalTriangles.PASCAL_1, PascalTriangles.PASCAL_2, PascalTriangles.PASCAL_3)),
            Arguments.of(4, List.of(
                    PascalTriangles.PASCAL_1, PascalTriangles.PASCAL_2, PascalTriangles.PASCAL_3,
                    PascalTriangles.PASCAL_4)),
            Arguments.of(5, List.of(
                    PascalTriangles.PASCAL_1, PascalTriangles.PASCAL_2, PascalTriangles.PASCAL_3,
                    PascalTriangles.PASCAL_4, PascalTriangles.PASCAL_5)),
            Arguments.of(6,
                    List.of(PascalTriangles.PASCAL_1, PascalTriangles.PASCAL_2, PascalTriangles.PASCAL_3,
                            PascalTriangles.PASCAL_4, PascalTriangles.PASCAL_5, PascalTriangles.PASCAL_6)),
            Arguments.of(7,
                    List.of(PascalTriangles.PASCAL_1, PascalTriangles.PASCAL_2, PascalTriangles.PASCAL_3,
                            PascalTriangles.PASCAL_4, PascalTriangles.PASCAL_5, PascalTriangles.PASCAL_6,
                            PascalTriangles.PASCAL_7)),
            Arguments.of(8,
                    List.of(PascalTriangles.PASCAL_1, PascalTriangles.PASCAL_2, PascalTriangles.PASCAL_3,
                            PascalTriangles.PASCAL_4, PascalTriangles.PASCAL_5, PascalTriangles.PASCAL_6,
                            PascalTriangles.PASCAL_7, PascalTriangles.PASCAL_8)),
            Arguments.of(9,
                    List.of(PascalTriangles.PASCAL_1, PascalTriangles.PASCAL_2, PascalTriangles.PASCAL_3,
                            PascalTriangles.PASCAL_4, PascalTriangles.PASCAL_5, PascalTriangles.PASCAL_6,
                            PascalTriangles.PASCAL_7, PascalTriangles.PASCAL_8, PascalTriangles.PASCAL_9)),
            Arguments.of(10,
                    List.of(PascalTriangles.PASCAL_1, PascalTriangles.PASCAL_2, PascalTriangles.PASCAL_3,
                            PascalTriangles.PASCAL_4, PascalTriangles.PASCAL_5, PascalTriangles.PASCAL_6,
                            PascalTriangles.PASCAL_7, PascalTriangles.PASCAL_8, PascalTriangles.PASCAL_9,
                            PascalTriangles.PASCAL_10))
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void pascalTriangleTest(int n, List<List<Integer>> expected) {
        TestUtil.assertDoubleListEquals(expected, PascalTriangle.pascalTriangle(n));
    }
}
