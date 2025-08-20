package com.lxy.leetcode.misc;

/**
 * <a href="https://leetcode.cn/problems/count-asterisks/">统计星号</a>
 */
public class CountAsterisks {
    public static int countAsterisks(String s) {
        var result = 0;
        var count = true;
        for (var i = 0; i < s.length(); i++) {
            var ch = s.charAt(i);
            switch (ch) {
                case '|' -> count = !count;
                case '*' -> {
                    if (count) {
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
