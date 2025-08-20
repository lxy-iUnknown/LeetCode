package com.lxy.leetcode.string;

/**
 * <a href="https://leetcode.cn/problems/longest-common-prefix/">最长公共前缀</a>
 */
public class LongestCommonPrefix {

    private static String longestCommonPrefix(String left, String right) {
        var min = Math.min(left.length(), right.length());
        int i;
        for (i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                break;
            }
        }
        return left.substring(0, i);
    }

    public static String longestCommonPrefixVertical(String[] strings) {
        var minLength = Integer.MAX_VALUE;
        var count = strings.length;
        var firstString = strings[0];
        int i;
        for (i = 0; i < count; i++) {
            var length = strings[i].length();
            if (length < minLength) {
                minLength = length;
            }
        }
        outer:
        for (i = 0; i < minLength; i++) {
            var ch = firstString.charAt(i);
            for (var j = 1; j < strings.length; j++) {
                if (strings[j].charAt(i) != ch) {
                    break outer;
                }
            }
        }
        return firstString.substring(0, i);
    }

    public static String longestCommonPrefixHorizontal(String[] strings) {
        var prefix = strings[0];
        for (var i = 1; i < strings.length; i++) {
            if (prefix.isEmpty()) {
                break;
            }
            prefix = longestCommonPrefix(prefix, strings[i]);
        }
        return prefix;
    }
}
