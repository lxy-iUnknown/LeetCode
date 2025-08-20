package com.lxy.leetcode.string;

/**
 * <a href="https://leetcode.cn/problems/reverse-string/">字符串反转</a>
 */
public class ReverseString {
    public static void reverseString(char[] s) {
        var i = 0;
        var j = s.length - 1;
        while (i < j) {
            var ch = s[i];
            s[i] = s[j];
            s[j] = ch;
            i++;
            j--;
        }
    }
}
