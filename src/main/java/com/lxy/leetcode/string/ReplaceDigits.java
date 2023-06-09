package com.lxy.leetcode.string;

/**
 * <a href="https://leetcode.cn/problems/replace-all-digits-with-characters/">将所有数字用字符替换</a>
 */
public class ReplaceDigits {
    private static char shift(char ch, int x) {
        return (char) (ch + x);
    }

    public static String replaceDigits(String s) {
        int length = s.length();
        char[] result = new char[length];
        char ch;
        for (int i = 0; i < length; i += 2) {
            ch = s.charAt(i);
            result[i] = ch;
            int next = i + 1;
            if (next < length) {
                ch = shift(ch, s.charAt(next) - '0');
                result[next] = ch;
            }
        }
        return new String(result, 0, length);
    }
}
