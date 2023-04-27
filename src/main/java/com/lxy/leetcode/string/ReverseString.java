package com.lxy.leetcode.string;

/**
 * <a href="https://leetcode.cn/problems/reverse-string/">字符串反转</a>
 */
public class ReverseString {
    public static void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        while (i < j) {
            char ch = s[i];
            s[i] = s[j];
            s[j] = ch;
            i++;
            j--;
        }
    }
}
