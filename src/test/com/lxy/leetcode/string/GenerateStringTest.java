package com.lxy.leetcode.string;

import com.lxy.leetcode.util.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.IntStream;

public class GenerateStringTest {
    public static IntStream arguments() {
        return IntStream.rangeClosed(1, 500);
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void generateStringTest(int n) {
        final int ALPHABET_SIZE = 26;

        String result = GenerateString.generateString(n);
        int length = result.length();
        // Make sure length equals
        Assertions.assertEquals(length, n);

        int[] counts = new int[ALPHABET_SIZE];
        for (int i = 0; i < length; i++) {
            char ch = result.charAt(i);
            if (ch < 'a' || ch > 'z') {
                TestUtil.assertFail("Character " + ch + " at index " + i +
                        " must be lower case Latin letter");
                return;
            }
            counts[ch - 'a']++;
        }
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            int count = counts[i];
            if (count > 0 && (count % 2) == 0) {
                TestUtil.assertFail("Character " + (char) ('a' + i) + " occurred even times(" + count + ")");
            }
        }
    }
}
