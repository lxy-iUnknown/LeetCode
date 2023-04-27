package com.lxy.leetcode.string;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/generate-a-string-with-characters-that-have-odd-counts/">生成每种字符都是奇数个的字符串</a>
 */
public class GenerateString {
    public static String generateString(int n) {
        char[] result = new char[n];
        Arrays.fill(result, 0, n, 'a');
        if ((n % 2) == 0) {
            result[n - 1] = 'b';
        }
        return new String(result, 0, n);
    }
}
