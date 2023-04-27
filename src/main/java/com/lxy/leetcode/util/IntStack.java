package com.lxy.leetcode.util;

import java.util.Arrays;

public class IntStack {
    private final int[] array;
    private int top;

    public IntStack(int capacity) {
        this.array = new int[capacity];
        this.top = -1;
    }

    private int peek(int index) {
        return array[index];
    }

    public int peek() {
        return peek(top);
    }

    public int peekNextTop() {
        return peek(top - 1);
    }

    public void push(int value) {
        array[++top] = value;
    }

    public int pop() {
        int value = peek();
        removeTop();
        return value;
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public int size() {
        return top + 1;
    }

    public void removeTop() {
        top--;
    }

    public int[] contents() {
        return Arrays.copyOfRange(array, 0, size());
    }
}
