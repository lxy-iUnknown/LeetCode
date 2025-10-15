package com.lxy.leetcode.string;

import java.util.HashSet;

/**
 * <a href="https://leetcode.cn/problems/number-of-different-integers-in-a-string/">字符串中不同整数的数目</a>
 */
public class NumDifferentIntegers {
    private static boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }

    public static int numDifferentIntegers(String word) {
        var set = new HashSet<String>();
        var i = 0;
        var j = 0;
        var length = word.length();
        while (true) {
            // 寻找数字开头
            while (i < length && !isDigit(word.charAt(i))) {
                i++;
            }
            if (i >= length) {
                break;
            }
            // 寻找数字结尾（j == length）也就意味着是最后一个数字
            j = i;
            while (j < length && isDigit(word.charAt(j))) {
                j++;
            }
            if (j > length) {
                break;
            }
            // 去除前导零（数字0会变成空字符串）
            while (i < length && word.charAt(i) == '0') {
                i++;
            }
            // 往哈希表里添加数字
            set.add(word.substring(i, j));
            i = j;
        }
        return set.size();
    }
}
