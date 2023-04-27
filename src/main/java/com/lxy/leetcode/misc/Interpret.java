package com.lxy.leetcode.misc;

/**
 * <a href="https://leetcode.cn/problems/goal-parser-interpretation/">设计Goal解析器</a>
 */
public class Interpret {
    public static String interpret(String command) {
        int length = command.length();
        int count = 0;
        char[] result = new char[length];
        int i = 0;
        while (i < length) {
            char ch = command.charAt(i++);
            switch (ch) {
                case 'G' -> result[count++] = 'G';
                case '(' -> {
                    // Next character always exists
                    // Index will not overflow
                    if (command.charAt(i) == ')') {
                        result[count++] = 'o';
                        i++;
                    } else {
                        result[count++] = 'a';
                        result[count++] = 'l';
                        i += 3;
                    }
                }
            }
        }
        return new String(result, 0, count);
    }
}
