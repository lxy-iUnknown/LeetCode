package com.lxy.leetcode.math;

import com.lxy.leetcode.util.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.FieldSource;

import java.util.List;

public class KthCharacterTest {
    public static final List<Integer> ARGUMENTS = TestUtil.generateRangeArray(1, 50);
    private static final char[] RESULTS = new char[]{0, 'a', 'b', 'b', 'c', 'b', 'c', 'c', 'd', 'b', 'c', 'c', 'd', 'c', 'd', 'd', 'e', 'b', 'c', 'c', 'd', 'c', 'd', 'd', 'e', 'c', 'd', 'd', 'e', 'd', 'e', 'e', 'f', 'b', 'c', 'c', 'd', 'c', 'd', 'd', 'e', 'c', 'd', 'd', 'e', 'd', 'e', 'e', 'f', 'c', 'd'};

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void kthCharacterTest(int n) {
        Assertions.assertEquals(RESULTS[n], KthCharacter.kthCharacter(n));
    }

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void kthCharacterOptimizedTest(int n) {
        Assertions.assertEquals(RESULTS[n], KthCharacter.kthCharacterOptimized(n));
    }
}
