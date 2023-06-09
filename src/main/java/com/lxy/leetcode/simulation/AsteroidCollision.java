package com.lxy.leetcode.simulation;

import com.lxy.leetcode.util.IntStack;

/**
 * <a href="https://leetcode.cn/problems/XagZNi/">小行星碰撞</a>
 */
public class AsteroidCollision {

    private static void checkAndPush(IntStack stack, int asteroid) {
        if (stack.isEmpty()) {
            stack.push(asteroid);
        } else {
            int top = stack.peek();
            // Asteroids will probably collide
            if (top > 0 && asteroid < 0) {
                int temp = -asteroid;
                if (top == temp) {
                    // Both old and new asteroid will explode
                    stack.removeTop();
                } else if (top < temp) {
                    // Old asteroid will explode
                    stack.removeTop();
                    checkAndPush(stack, asteroid);
                }
            } else {
                stack.push(asteroid);
            }
        }
    }

    private static void checkAndPushLoop(IntStack stack, int asteroid) {
        boolean isAlive = true;
        int top;
        while ((isAlive && asteroid < 0) /* Asteroids will probably collide */ &&
                (!stack.isEmpty() && (top = stack.peek()) > 0)) {
            int temp = -asteroid;
            if (top == temp) {
                // Both old and new asteroid will explode
                stack.removeTop();
                isAlive = false;
            } else if (top < temp) {
                // Old asteroid will explode
                stack.removeTop();
            } else {
                // New asteroid will explode
                isAlive = false;
            }
        }
        if (isAlive) {
            stack.push(asteroid);
        }
    }

    public static int[] asteroidCollision(int[] asteroids) {
        int length = asteroids.length;
        IntStack stack = new IntStack(length) ;
        for (int asteroid : asteroids) {
            checkAndPush(stack, asteroid);
        }
        return stack.contents();
    }

    public static int[] asteroidCollisionLoop(int[] asteroids) {
        int length = asteroids.length;
        IntStack stack = new IntStack(length) ;
        for (int asteroid : asteroids) {
            checkAndPushLoop(stack, asteroid);
        }
        return stack.contents();
    }
}
