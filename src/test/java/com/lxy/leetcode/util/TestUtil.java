package com.lxy.leetcode.util;

import org.junit.jupiter.api.AssertionFailureBuilder;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;
import java.util.concurrent.ConcurrentHashMap;

public class TestUtil {
    private static final ConcurrentHashMap<Range, RangeList> ARRAY_CACHE = new ConcurrentHashMap<>();

    public static List<Integer> generateRangeArray(int start, int end) {
        return ARRAY_CACHE.computeIfAbsent(
                new Range(start, end),
                range -> new RangeList(range.start, range.end));
    }

    public static void assertFail(String message) {
        AssertionFailureBuilder.assertionFailure()
                .message(message)
                .buildAndThrow();
    }

    public static void assertFail(Object expected, Object actual, String message) {
        AssertionFailureBuilder.assertionFailure()
                .expected(expected)
                .actual(actual)
                .message(message)
                .buildAndThrow();
    }

    public static void assertFuzzyEquals(double expected, double actual, double tolerance) {
        if (Math.abs(expected - actual) > tolerance) {
            assertFail(expected, actual, "Fuzzy equals failed, tolerance = " + tolerance);
        }
    }

    private static void assertArrayLengthEquals(int[] expected, int actualLength) {
        Assertions.assertEquals(expected.length, actualLength, "Array length differ");
    }

    private static void assertArrayContentEquals(int[] expected, int[] actual, int actualLength) {
        for (var i = 0; i < actualLength; i++) {
            Assertions.assertEquals(expected[i], actual[i],
                    "Array elements differ at index " + i);
        }
    }

    public static void assertArrayEquals(int[] expected, int[] actual, int actualLength) {
        assertArrayLengthEquals(expected, actualLength);
        assertArrayContentEquals(expected, actual, actualLength);
    }

    public static void assertArrayUnorderedEquals(int[] expected, int[] actual, int actualLength) {
        assertArrayLengthEquals(expected, actualLength);
        Arrays.sort(expected, 0, actualLength);
        Arrays.sort(actual, 0, actualLength);
        assertArrayContentEquals(expected, actual, actualLength);
    }

    public static void assertListEquals(List<Integer> expected, List<Integer> actual) {
        assert expected instanceof RandomAccess;
        assert actual instanceof RandomAccess;
        var size = expected.size();
        Assertions.assertEquals(size, actual.size(), "Size differ");
        for (var i = 0; i < size; i++) {
            Assertions.assertEquals(expected.get(i), actual.get(i), "Element at index " + i + " differ");
        }
    }

    public static void assertDoubleListEquals(List<List<Integer>> expected, List<List<Integer>> actual) {
        assert expected instanceof RandomAccess;
        assert actual instanceof RandomAccess;
        var size = expected.size();
        Assertions.assertEquals(size, actual.size(), "Size differ");
        for (var i = 0; i < size; i++) {
            assertListEquals(expected.get(i), actual.get(i));
        }
    }

    private record Range(int start, int end) {

    }
}
