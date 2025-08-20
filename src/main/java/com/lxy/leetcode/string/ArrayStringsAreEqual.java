package com.lxy.leetcode.string;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/check-if-two-string-arrays-are-equivalent/">检查两个字符串数组是否相等</a>
 */
public class ArrayStringsAreEqual {
    private static int totalStringSize(String[] words) {
        var sum = 0;
        for (var word : words) {
            sum += word.length();
        }
        return sum;
    }

    private static char[] flatten(String[] words, int totalSize) {
        var table = new char[totalSize];
        var index = 0;
        for (var word : words) {
            for (var i = 0; i < word.length(); i++) {
                table[index++] = word.charAt(i);
            }
        }
        return table;
    }

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        var totalSize1 = totalStringSize(word1);
        var totalSize2 = totalStringSize(word2);
        if (totalSize1 != totalSize2) {
            return false;
        }
        return Arrays.equals(
                flatten(word1, totalSize1), 0, totalSize1,
                flatten(word2, totalSize2), 0, totalSize2);
    }

    public static boolean arrayStringsAreEqualOptimized(String[] word1, String[] word2) {
        var i = 0;
        var j = 0;
        var wordI = 0;
        var wordJ = 0;
        var word1Length = word1.length;
        var word2Length = word2.length;
        while (wordI < word1Length && wordJ < word2Length) {
            var word1Item = word1[wordI];
            var word2Item = word2[wordJ];
            if (word1Item.charAt(i++) != word2Item.charAt(j++)) {
                return false;
            }
            if (i >= word1Item.length()) {
                wordI++;
                i = 0;
            }
            if (j >= word2Item.length()) {
                wordJ++;
                j = 0;
            }
        }
        // Both wordI and wordJ reached end
        return wordI >= word1Length && wordJ >= word2Length;
    }
}
