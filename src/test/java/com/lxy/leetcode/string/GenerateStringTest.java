package com.lxy.leetcode.string;

import com.lxy.leetcode.util.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.FieldSource;

import java.util.List;

public class GenerateStringTest {
    public static final List<Integer> ARGUMENTS = TestUtil.generateRangeArray(1, 500);

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void generateStringTest(int n) {
        final int ALPHABET_SIZE = 26;

        var result = GenerateString.generateString(n);
        var length = result.length();
        // Make sure length equals
        Assertions.assertEquals(length, n);

        var counts = new int[ALPHABET_SIZE];
        for (var i = 0; i < length; i++) {
            var ch = result.charAt(i);
            if (ch < 'a' || ch > 'z') {
                TestUtil.assertFail("Character " + ch + " at index " + i +
                        " must be lower case Latin letter");
                return;
            }
            counts[ch - 'a']++;
        }
        for (var i = 0; i < ALPHABET_SIZE; i++) {
            var count = counts[i];
            if (count > 0 && (count % 2) == 0) {
                TestUtil.assertFail("Character " + (char) ('a' + i) + " occurred even times(" + count + ")");
            }
        }
    }
}
