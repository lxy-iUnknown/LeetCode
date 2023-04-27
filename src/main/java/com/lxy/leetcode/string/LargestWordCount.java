package com.lxy.leetcode.string;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * <a href="https://leetcode.cn/problems/sender-with-largest-word-count/">最多单词数的发件人</a>
 */
public class LargestWordCount {

    private static int wordCount(String message) {
        int count = 0;
        int i = 0;
        while (i < message.length()) {
            if (message.charAt(i++) == ' ') {
                count++;
            }
        }
        return count + 1;
    }

    public static String largestWordCount(String[] messages, String[] senders) {
        TreeMap<String, Integer> wordCountMap = new TreeMap<>(Comparator.reverseOrder());
        int n = messages.length;
        for (int i = 0; i < n; i++) {
            wordCountMap.merge(senders[i], wordCount(messages[i]), Integer::sum);
        }
        int max = 0;
        for (int wordCount : wordCountMap.values()) {
            if (wordCount > max) {
                max = wordCount;
            }
        }
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            if (entry.getValue() == max) {
                return entry.getKey();
            }
        }
        // Should not happen
        return null;
    }

    public static String largestWordCountOptimized(String[] messages, String[] senders) {
        HashMap<String, Integer> wordCountMap = new HashMap<>();
        int n = messages.length;
        for (int i = 0; i < n; i++) {
            wordCountMap.merge(senders[i], wordCount(messages[i]), Integer::sum);
        }
        int max = 0;
        String result = "";
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            String sender = entry.getKey();
            int wordCount = entry.getValue();
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
