package com.lxy.leetcode.simulation;

/**
 * <a href="https://leetcode.cn/problems/goat-latin/">山羊拉丁文</a>
 */
public class ToGoatLatin {
    public static String toGoatLatin(String sentence) {
        return new Converter(sentence).convert();
    }

    private static class Converter {
        private final String sentence;
        private final StringBuilder sb = new StringBuilder();
        private int index = 1;

        public Converter(String sentence) {
            this.sentence = sentence;
        }

        private static boolean isVowel(char ch) {
            return "aeiouAEIOU".indexOf(ch) >= 0;
        }

        private void appendWord(int start, int end, boolean isLast) {
            var first = sentence.charAt(start);
            if (isVowel(first)) {
                sb.append(sentence, start, end);
            } else {
                sb.append(sentence, start + 1, end).append(first);
            }
            sb.append("ma").repeat('a', index++);
            if (!isLast) {
                sb.append(' ');
            }
        }

        public String convert() {
            var start = 0;
            var end = 0;
            while (true) {
                end = sentence.indexOf(' ', start);
                if (end < 0) {
                    // Last word [end, length]
                    appendWord(start, sentence.length(), true);
                    break;
                }
                // Word from [start, end]
                appendWord(start, end, false);
                // Next round
                start = end + 1;
            }
            return sb.toString();
        }
    }
}
