package com.lxy.leetcode.misc;

/**
 * <a href="https://leetcode.cn/problems/solve-the-equation/">求解方程</a>
 */
public class SolveEquation {
    private static final String INFINITE_SOLUTIONS = "Infinite solutions";
    private static final String NO_SOLUTION = "No solution";

    private static void parseAndAccumulate(String s, int start, int end,
                                           boolean negate, Polynomial p) {
        var i = start;
        while (i < end) {
            var number = 0;
            // 最终的系数是否反号
            var negative = negate;
            // 之前是否解析过数字（如果解析到x则忽略该标志）
            var hasDigit = false;
            // 之前是否解析过x
            var isX = false;
            // x系数是否为0（如果未解析到x则忽略该标志）
            var isXZero = false;
            while (i < end) {
                var ch = s.charAt(i);
                if (ch == '+' || ch == '-') {
                    if (hasDigit) {
                        // 如果前一个字符是数字，则表明前一段式子已经解析结束（这种情况不消耗字符）
                        break;
                    }
                    if (ch == '-') {
                        // 反号
                        negative = !negative;
                    }
                    // 消耗一个字符（下同）
                    i++;
                } else if (ch == 'x') {
                    // 解析到x，此时前一段式子已经解析结束
                    isX = true;
                    i++;
                    break;
                } else {
                    // 解析到数字
                    var digit = ch - '0';
                    // 判断x系数是否为0
                    isXZero = digit == 0;
                    number = number * 10 + digit;
                    hasDigit = true;
                    i++;
                }
            }
            if (isX && !isXZero) {
                // 如果x前面没有系数，则默认为1
                number = number == 0 ? 1 : number;
            }
            // 反号
            if (negative) {
                number = -number;
            }
            if (isX) {
                // 累加x系数
                p.x += number;
            } else {
                // 累加常数项系数
                p.c += number;
            }
        }
    }

    public static String solveEquation(String equation) {
        var index = equation.indexOf('=');
        var p = new Polynomial();
        parseAndAccumulate(equation, 0, index, false /* 不变号 */, p);
        parseAndAccumulate(equation, index + 1, equation.length(), true /* 移项变号 */, p);
        // 移项变号
        p.c = -p.c;
        if (p.x == 0) {
            return p.c == 0 ? INFINITE_SOLUTIONS : NO_SOLUTION;
        }
        return p.c % p.x == 0 ? "x=" + p.c / p.x : NO_SOLUTION;
    }

    private static class Polynomial {
        // x系数
        private int x;
        // 常数项系数
        private int c;
    }
}
