package com.lxy.leetcode.array1d;

import com.lxy.leetcode.util.TestUtil;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class RemoveDuplicatesTest {

    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of(new int[]{1, 1, 2}, new int[]{1, 2}),
            Arguments.of(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}, new int[]{0, 1, 2, 3, 4})
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void removeDuplicates(int[] numbers, int[] expected) {
        TestUtil.assertArrayEquals(expected, numbers, RemoveDuplicates.removeDuplicates(numbers));
    }
}
