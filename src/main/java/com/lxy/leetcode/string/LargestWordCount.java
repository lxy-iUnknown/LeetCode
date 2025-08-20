package com.lxy.leetcode.string;

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * <a href="https://leetcode.cn/problems/sender-with-largest-word-count/">最多单词数的发件人</a>
 */
public class LargestWordCount {

    private static int wordCount(String message) {
        var count = 0;
        var i = 0;
        while (i < message.length()) {
            if (message.charAt(i++) == ' ') {
                count++;
            }
        }
        return count + 1;
    }

    public static String largestWordCount(String[] messages, String[] senders) {
        var wordCountMap = new TreeMap<String, Integer>(Comparator.reverseOrder());
        var n = messages.length;
        for (var i = 0; i < n; i++) {
            wordCountMap.merge(senders[i], wordCount(messages[i]), Integer::sum);
        }
        var max = 0;
        for (var wordCount : wordCountMap.values()) {
            if (wordCount > max) {
                max = wordCount;
            }
        }
        for (var entry : wordCountMap.entrySet()) {
            if (entry.getValue() == max) {
                return entry.getKey();
            }
        }
        // Should not happen
        return null;
    }

    public static String largestWordCountOptimized(String[] messages, String[] senders) {
        var wordCountMap = new HashMap<String, Integer>();
        var n = messages.length;
        for (var i = 0; i < n; i++) {
            wordCountMap.merge(senders[i], wordCount(messages[i]), Integer::sum);
        }
        var max = 0;
        var result = "";
        for (var entry : wordCountMap.entrySet()) {
            var sender = entry.getKey();
            var wordCount = entry.getValue();
            if (wordCount > max) {
                max = wordCount;
                result = sender;
            } else if (wordCount == max && sender.compareTo(result) > 0) {
                result = sender;
            }
        }
        return result;
    }
}
