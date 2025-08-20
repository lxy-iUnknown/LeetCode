package com.lxy.leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * <a href="https://leetcode.cn/problems/word-pattern/">单词规律</a>
 */
public class WordPattern {

    private static ArrayList<String> splitWords(String s) {
        var length = s.length();
        var words = new ArrayList<String>(length);
        var i = s.indexOf(' ');
        var old = 0;
        while (i >= 0) {
            words.add(s.substring(old, i));
            old = i + 1;
            i = s.indexOf(' ', old);
        }
        // Add last word
        words.add(s.substring(old, length));
        return words;
    }

    public static boolean wordPattern(String pattern, String s) {
        var words = splitWords(s);
        var length = words.size();
        if (length != pattern.length()) {
            return false;
        }
        var map = new WordLetterTwoWayMap();
        for (var i = 0; i < length; i++) {
            var letter = pattern.charAt(i);
            var word = words.get(i);
            if (map.exists(letter, word)) {
                return false;
            }
            map.put(letter, word);
        }
        return true;
    }

    public static boolean wordPatternOptimized(String pattern, String s) {
        var map = new WordLetterTwoWayMap();

        var wordLength = s.length();
        var patternLength = pattern.length();
        var i = s.indexOf(' ');
        var j = 0;
        var old = 0;
        char letter;
        String word;
        while (i >= 0 && j < patternLength) {
            letter = pattern.charAt(j++);
            word = s.substring(old, i);
            if (map.exists(letter, word)) {
                return false;
            }
            map.put(letter, word);
            old = i + 1;
            i = s.indexOf(' ', old);
        }
        // Try test last letter and last word
        if (i < 0 && j == patternLength - 1) {
            return !map.exists(pattern.charAt(j), s.substring(old, wordLength));
        }
        return false;
    }

    private static class WordLetterTwoWayMap {
        private final String[] letterToWordMap = new String[26];
        private final HashMap<String, Character> wordToLetterMap = new HashMap<>();

        private boolean existsLetterToWord(char letter, String word) {
            var value = letterToWordMap[letter - 'a'];
            return value != null && !value.equals(word);
        }

        private boolean existsWordToLetter(char letter, String word) {
            var value = wordToLetterMap.get(word);
            return value != null && value != letter;
        }

        public boolean exists(char letter, String word) {
            return existsLetterToWord(letter, word) || existsWordToLetter(letter, word);
        }

        public void put(char letter, String word) {
            letterToWordMap[letter - 'a'] = word;
            wordToLetterMap.put(word, letter);
        }
    }
}
