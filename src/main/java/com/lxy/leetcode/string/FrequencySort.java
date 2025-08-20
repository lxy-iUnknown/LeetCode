package com.lxy.leetcode.string;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.cn/problems/sort-characters-by-frequency/">根据字符出现频率排序</a>
 */
public class FrequencySort {
    // '0' ~ '9' = 48 ~ 57
    // 'A' ~ 'Z' = 65 ~ 90
    // 'a' ~ 'z' = 97 ~ 122
    private static final int CHARACTER_COUNT_SIZE = 'z' - '0' + 1;
    // Sort in descending order
    private static final Comparator<CharacterCount> COMPARATOR =
            (c1, c2) -> Integer.compare(c2.count, c1.count);

    private static CharacterCount[] initialize() {
        var counts = new CharacterCount[CHARACTER_COUNT_SIZE];
        for (var i = 0; i < CHARACTER_COUNT_SIZE; i++) {
            counts[i] = new CharacterCount();
        }
        return counts;
    }

    public static String frequencySort(String s) {
        var counts = initialize();
        var length = s.length();
        for (var i = 0; i < length; i++) {
            var ch = s.charAt(i);
            var characterCount = counts[ch - '0'];
            characterCount.character = ch;
            characterCount.count++;
        }
        Arrays.sort(counts, 0, CHARACTER_COUNT_SIZE, COMPARATOR);
        var result = new char[length];
        var index = 0;
        for (var i = 0; i < CHARACTER_COUNT_SIZE; i++) {
            var characterCount = counts[i];
            var count = characterCount.count;
            var newIndex = index + count;
            if (count != 0) {
                Arrays.fill(result, index, newIndex, characterCount.character);
            }
            index = newIndex;
        }
        return new String(result, 0, length);
    }

    private static class CharacterCount {
        private char character;
        private int count;
    }
}
