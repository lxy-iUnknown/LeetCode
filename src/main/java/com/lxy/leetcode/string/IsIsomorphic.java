package com.lxy.leetcode.string;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/isomorphic-strings/">同构字符串</a>
 */
public class IsIsomorphic {
    private static final int ASCII_MAX = 128;

    private static char[] createMapping() {
        char[] mapping = new char[ASCII_MAX];
        Arrays.fill(mapping, 0, ASCII_MAX, (char) ASCII_MAX);
        return mapping;
    }

    private static boolean isInvalidMapping(char[] mapping, char src, char dest) {
        int value = mapping[src];
        // Not mapped or equals
        return value < ASCII_MAX && value != dest;
    }

    public static boolean isIsomorphic(String s, String t) {
        int length = s.length();
        if (length != t.length()) {
            return false;
        }
        // src to dest mapping
        char[] mapping = createMapping();
        // dest to src mapping
        char[] reverseMapping = createMapping();
        for (int i = 0; i < length; i++) {
            char src = s.charAt(i);
            char dest = t.charAt(i);
            if (isInvalidMapping(mapping, src, dest) ||
                    isInvalidMapping(reverseMapping, dest, src)) {
                return false;
            }
            mapping[src] = dest;
            reverseMapping[dest] = src;
        }
        return true;
    }
}
