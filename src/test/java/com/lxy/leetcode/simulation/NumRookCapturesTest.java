package com.lxy.leetcode.simulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class NumRookCapturesTest {
    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of(new char[][]{
                    new char[]{'.', '.', '.', '.', '.', '.', '.', '.'},
                    new char[]{'.', '.', '.', 'p', '.', '.', '.', '.'},
                    new char[]{'.', '.', '.', 'R', '.', '.', '.', 'p'},
                    new char[]{'.', '.', '.', '.', '.', '.', '.', '.'},
                    new char[]{'.', '.', '.', '.', '.', '.', '.', '.'},
                    new char[]{'.', '.', '.', 'p', '.', '.', '.', '.'},
                    new char[]{'.', '.', '.', '.', '.', '.', '.', '.'},
                    new char[]{'.', '.', '.', '.', '.', '.', '.', '.'}}, 3),
            Arguments.of(new char[][]{
                    new char[]{'.', '.', '.', '.', '.', '.', '.', '.'},
                    new char[]{'.', 'p', 'p', 'p', 'p', 'p', '.', '.'},
                    new char[]{'.', 'p', 'p', 'B', 'p', 'p', '.', '.'},
                    new char[]{'.', 'p', 'B', 'R', 'B', 'p', '.', '.'},
                    new char[]{'.', 'p', 'p', 'B', 'p', 'p', '.', '.'},
                    new char[]{'.', 'p', 'p', 'p', 'p', 'p', '.', '.'},
                    new char[]{'.', '.', '.', '.', '.', '.', '.', '.'},
                    new char[]{'.', '.', '.', '.', '.', '.', '.', '.'}}, 0),
            Arguments.of(new char[][]{
                    new char[]{'.', '.', '.', '.', '.', '.', '.', '.'},
                    new char[]{'.', '.', '.', 'p', '.', '.', '.', '.'},
                    new char[]{'.', '.', '.', 'p', '.', '.', '.', '.'},
                    new char[]{'p', 'p', '.', 'R', '.', 'p', 'B', '.'},
                    new char[]{'.', '.', '.', '.', '.', '.', '.', '.'},
                    new char[]{'.', '.', '.', 'B', '.', '.', '.', '.'},
                    new char[]{'.', '.', '.', 'p', '.', '.', '.', '.'},
                    new char[]{'.', '.', '.', '.', '.', '.', '.', '.'}}, 3)
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void numRookCapturesTest(char[][] board, int expected) {
        Assertions.assertEquals(expected, NumRookCaptures.numRookCaptures(board));
    }

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void numRookCapturesExtensionTest(char[][] board, int expected) {
        Assertions.assertEquals(expected, NumRookCaptures.numRookCapturesExtension(board));
    }
}
