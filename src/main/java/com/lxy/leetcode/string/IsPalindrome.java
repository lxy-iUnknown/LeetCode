package com.lxy.leetcode.string;

/**
 * <a href="https://leetcode.cn/problems/valid-palindrome/">验证回文串</a>
 */
public class IsPalindrome {

    private static char tryChange(char ch) {
        if ((ch >= '0' && ch <= '9') || ch >= 'a' && ch <= 'z') {
            return ch;
        }
        if (ch >= 'A' && ch <= 'Z') {
            return (char) (ch + ('a' - 'A'));
        }
        // ch为可打印的ASCII字符
        return Character.MAX_VALUE;
    }

    public static boolean isPalindrome(String s) {
        var length = s.length();
        var i = 0;
        var j = length - 1;
        while (i < j) {
            var ch1 = tryChange(s.charAt(i));
            var ch2 = tryChange(s.charAt(j));
            if ((short) ch1 < 0) {
                i++;
            } else if ((short) ch2 < 0) {
                j--;
            } else {
                if (ch1 == ch2) {
                    i++;
                    j--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
