package com.lxy.leetcode.string;

/**
 * <a href="https://leetcode.cn/problems/verifying-an-alien-dictionary/">验证外星语词典</a>
 */
public class IsAlienSorted {
    public static boolean isAlienSorted(String[] words, String order) {
        var alphabet = new AlienAlphabet(order);
        for (var i = 0; i < words.length - 1; i++) {
            if (!alphabet.isLessOrEqual(words[i], words[i + 1])) {
                return false;
            }
        }
        return true;
    }

    private static class AlienAlphabet {
        private final int[] alphabet;

        public AlienAlphabet(String order) {
            var alphabet = new int[26];
            for (var i = 0; i < order.length(); i++) {
                alphabet[order.charAt(i) - 'a'] = i;
            }
            this.alphabet = alphabet;
        }

        public boolean isLessOrEqual(String s1, String s2) {
            var l1 = s1.length();
            var l2 = s2.length();
            for (var i = 0; i < Math.min(l1, l2); i++) {
                var c1 = s1.charAt(i);
                var c2 = s2.charAt(i);
                if (c1 == c2) {
                    continue;
                }
                var a1 = alphabet[c1 - 'a'];
                var a2 = alphabet[c2 - 'a'];
                if (a1 > a2) {
                    return false;
                }
                if (a1 < a2) {
                    return true;
                }
            }
            return l1 <= l2;
        }
    }
}
