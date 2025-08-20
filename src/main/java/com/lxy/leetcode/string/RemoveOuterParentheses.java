package com.lxy.leetcode.string;

/**
 * <a href="https://leetcode.cn/problems/remove-outermost-parentheses/">删除最外层括号</a>
 */
public class RemoveOuterParentheses {
    public static String removeOuterParentheses(String s) {
        var length = s.length();
        // At lease one parenthesis primitive
        var sb = new StringBuilder(length - 2);
        var startIndex = 0;
        var stackTop = 0;
        for (var i = 0; i < length; i++) {
            var ch = s.charAt(i);
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
        var length = s.length();
        // At lease one parenthesis primitive
        var buffer = new char[length - 2];
        var bufferLength = 0;
        var stackTop = -1;
        for (var i = 0; i < length; i++) {
            var ch = s.charAt(i);
            if (ch == '(' && ++stackTop > 0) {
                buffer[bufferLength++] = '(';
            } else if (ch == ')' && stackTop-- > 0) {
                buffer[bufferLength++] = ')';
            }
        }
        return new String(buffer, 0, bufferLength);
    }
}
