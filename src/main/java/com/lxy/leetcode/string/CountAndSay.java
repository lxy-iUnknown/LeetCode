package com.lxy.leetcode.string;

/**
 * <a href="https://leetcode.cn/problems/count-and-say/">外观数列</a>
 */
public class CountAndSay {

    private static final String[] TABLE = CountAndSayTableGenerator.generate(30);

    public static String countAndSay(int n) {
        return TABLE[n - 1];
    }
}
