package com.lxy.leetcode.string;

/**
 * <a href="https://leetcode.cn/problems/first-unique-character-in-a-string/">第一个唯一字符</a>
 */
public class FirstUniqueChar {
    public static int firstUniqueChar(String s) {
        // Zero: 0, One: 1, More than one: 2
        var counters = new byte[26];
        for (var i = 0; i < s.length(); i++) {
            var index = s.charAt(i) - 'a';
            var counter = counters[index];
            if (counter++ <= 1) {
                counters[index] = counter;
            }
        }
        for (var i = 0; i < s.length(); i++) {
            var index = s.charAt(i) - 'a';
            if (counters[index] == 1) {
                return i;
            }
        }
        return -1;
    }
}
