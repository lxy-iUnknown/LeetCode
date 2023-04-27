package com.lxy.leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * <a href="https://leetcode.cn/problems/word-pattern/">单词规律</a>
 */
public class WordPattern {

    private static class WordLetterTwoWayMap {
        private final String[] letterToWordMap = new String[26];
        private final HashMap<String, Character> wordToLetterMap = new HashMap<>();

        private boolean existsLetterToWord(char letter, String word) {
            String value = letterToWordMap[letter - 'a'];
            return value != null && !value.equals(word);
        }

        private boolean existsWordToLetter(char letter, String word) {
            Character value = wordToLetterMap.get(word);
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

    private static ArrayList<String> splitWords(String s) {
        int length = s.length();
        ArrayList<String> words = new ArrayList<>(length);
        int i = s.indexOf(' ');
        int old = 0;
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
        ArrayList<String> words = splitWords(s);
        int length = words.size();
        if (length != pattern.length()) {
            return false;
        }
        WordLetterTwoWayMap map = new WordLetterTwoWayMap();
        for (int i = 0; i < length; i++) {
            char letter = pattern.charAt(i);
            String word = words.get(i);
            if (map.exists(letter, word))  {
                return false;
            }
            map.put(letter, word);
        }
        return true;
    }

    public static boolean wordPatternOptimized(String pattern, String s) {
        WordLetterTwoWayMap map = new WordLetterTwoWayMap();

        int wordLength = s.length(), patternLength = pattern.length();
        int i = s.indexOf(' '), j = 0;
        int old = 0;
        char letter;
        String word;
        while (i >= 0 && j < patternLength) {
            letter = pattern.charAt(j++);
            word = s.substring(old, i);
            if (map.exists(letter, word))  {
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
}
