package com.lxy.leetcode.string;

/**
 * <a href="https://leetcode.cn/problems/remove-outermost-parentheses/">删除最外层括号</a>
 */
public class RemoveOuterParentheses {
    public static String removeOuterParentheses(String s) {
        int length = s.length();
        // At lease one parenthesis primitive
        StringBuilder sb = new StringBuilder(length - 2);
        int startIndex = 0;
        int stackTop = 0;
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stackTop++;
            } else {
                if (--stackTop == 0) {
                    // Append parentheses
                    sb.append(s, startIndex + 1, i);
                    startIndex = i + 1;
                }
            }
        }
        return sb.toString();
    }

    public static String removeOuterParenthesesOptimized(String s) {
        int length = s.length();
        // At lease one parenthesis primitive
        char[] buffer = new char[length - 2];
        int bufferLength = 0;
        int stackTop = -1;
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (ch == '(' && ++stackTop > 0) {
                buffer[bufferLength++] = '(';
            } else if (ch == ')' && stackTop-- > 0) {
                buffer[bufferLength++] = ')';
            }
        }
        return new String(buffer, 0, bufferLength);
    }
}
