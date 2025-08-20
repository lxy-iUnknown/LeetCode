package com.lxy.leetcode.misc;

/**
 * <a href="https://leetcode.cn/problems/valid-parentheses/">有效的括号</a>
 */
public class IsValidParentheses {
    private static boolean noMatchParenthesis(CharStack stack, char ch) {
        return stack.isEmpty() || stack.pop() != ch;
    }

    public static boolean isValidParentheses(String s) {
        var length = s.length();
        var stack = new CharStack(length);
        for (var i = 0; i < length; i++) {
            var ch = s.charAt(i);
            switch (ch) {
                case '(', '[', '{' -> stack.push(ch);
                case ')' -> {
                    if (noMatchParenthesis(stack, '(')) {
                        return false;
                    }
                }
                case ']' -> {
                    if (noMatchParenthesis(stack, '[')) {
                        return false;
                    }
                }
                case '}' -> {
                    if (noMatchParenthesis(stack, '{')) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    private static class CharStack {
        private final char[] array;
        private int top;

        public CharStack(int capacity) {
            this.array = new char[capacity];
            this.top = -1;
        }

        public void push(char value) {
            array[++top] = value;
        }

        public char pop() {
            return array[top--];
        }

        public boolean isEmpty() {
            return top < 0;
        }
    }
}
