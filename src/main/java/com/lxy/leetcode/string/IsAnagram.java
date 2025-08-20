package com.lxy.leetcode.string;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/valid-anagram/">有效的字母异位词</a>
 */
public class IsAnagram {
    private static int counterIndex(String s, int i) {
        return s.charAt(i) - 'a';
    }

    private static char[] buildCounters(String s) {
        // s.length <= 5 * 10^4
        var counters = new char[26];
        for (var i = 0; i < s.length(); i++) {
            counters[counterIndex(s, i)]++;
        }
        return counters;
    }

    public static boolean isAnagram(String s, String t) {
        return Arrays.equals(buildCounters(s), buildCounters(t));
    }

    public static boolean isAnagramOptimized(String s, String t) {
        final int ALPHABET_SIZE = 26;

        var counters = new int[ALPHABET_SIZE];
        var length1 = s.length();
        var length2 = t.length();
        var length = Math.min(length1, length2);
        int i;
        for (i = 0; i < length; i++) {
            counters[counterIndex(s, i)]++;
            counters[counterIndex(t, i)]--;
        }
        while (i < length1) {
            counters[counterIndex(s, i++)]++;
        }
        while (i < length2) {
            counters[counterIndex(t, i++)]++;
        }
        for (i = 0; i < ALPHABET_SIZE; i++) {
            if (counters[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
