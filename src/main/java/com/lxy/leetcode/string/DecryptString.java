package com.lxy.leetcode.string;

/**
 * <a href="https://leetcode.cn/problems/decrypt-string-from-alphabet-to-integer-mapping/">解码字母到整数映射</a>
 */
public class DecryptString {

    public static String freqAlphabets(String s) {
        int length = s.length();
        StringBuilder sb = new StringBuilder(length);
        int i = 0;
        while (i < length) {
            char ch = s.charAt(i++);
            int delta;
            if (length - i >= 2 && s.charAt(i + 1) == '#') {
                // Two-digit char
                delta = (ch == '1' ? 'j' - '0' : 't' - '0');
                ch = s.charAt(i);
                i += 2;
            } else {
                // One-digit char
                delta = 'a' - '1';
            }
            sb.append((char) (ch + delta));
        }
        return sb.toString();
    }
}
