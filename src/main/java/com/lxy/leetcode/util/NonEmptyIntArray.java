package com.lxy.leetcode.util;

import java.util.Objects;

public class NonEmptyIntArray {

    private final int first;
    private final int[] rest;

    public NonEmptyIntArray(int first) {
        this(first, Constants.EMPTY_ARRAY_INT);
    }

    public NonEmptyIntArray(int first, int... rest) {
        this.first = first;
        this.rest = rest;
    }

    public int first() {
        return first;
    }

    public int[] rest() {
        return rest;
    }

    private int getUnchecked(int index) {
        return index == 0 ? first : rest[index - 1];
    }

    public int length() {
        return rest.length + 1;
    }

    public int get(int index) {
        Objects.checkIndex(index, length());
        return getUnchecked(index);
    }

    @Override
    public String toString() {
        int iMax = length() - 1;
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; ; i++) {
            sb.append(getUnchecked(i));
            if (i == iMax) {
                return sb.append(']').toString();
            }
            sb.append(", ");
        }
    }
}
