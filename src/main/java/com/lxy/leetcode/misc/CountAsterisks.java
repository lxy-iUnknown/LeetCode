package com.lxy.leetcode.misc;

/**
 * <a href="https://leetcode.cn/problems/count-asterisks/">统计星号</a>
 */
public class CountAsterisks {
    public static int countAsterisks(String s) {
        int result = 0;
        boolean count = true;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
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
