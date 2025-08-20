package com.lxy.leetcode.simulation;

import com.lxy.leetcode.util.IntStack;

/**
 * <a href="https://leetcode.cn/problems/baseball-game/">棒球比赛</a>
 */
public class CalculatePoints {

    public static int calculatePoints(String[] operations) {
        var length = operations.length;
        var stack = new IntStack(length);
        var result = 0;
        for (String operation : operations) {
            switch (operation.charAt(0)) {
                case '+' -> stack.push(stack.peek() + stack.peekNextTop());
                case 'C' -> stack.pop();
                case 'D' -> stack.push(2 * stack.peek());
                default -> stack.push(Integer.parseInt(operation));
            }
        }
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}
