package com.lxy.leetcode.simulation;

import com.lxy.leetcode.util.IntStack;

/**
 * <a href="https://leetcode.cn/problems/baseball-game/">棒球比赛</a>
 */
public class CalculatePoints {

    @SuppressWarnings("ForLoopReplaceableByForEach")
    public static int calculatePoints(String[] operations) {
        int length = operations.length;
        IntStack stack = new IntStack(length);
        int result = 0;
        for (int i = 0; i < length; i++) {
            String operation = operations[i];
            switch (operation.charAt(0)) {
                case '+' -> {
                    stack.push(stack.peek() + stack.peekNextTop());
                }
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
