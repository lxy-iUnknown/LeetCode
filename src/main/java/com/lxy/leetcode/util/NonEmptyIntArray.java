package com.lxy.leetcode.util;

import java.util.Objects;

public record NonEmptyIntArray(int first, int... rest) {
    public NonEmptyIntArray(int first) {
        this(first, Constants.EMPTY_ARRAY_INT);
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
        var iMax = length() - 1;
        var sb = new StringBuilder();
        sb.append('[');
        for (var i = 0; ; i++) {
            sb.append(getUnchecked(i));
            if (i == iMax) {
                return sb.append(']').toString();
            }
            sb.append(", ");
        }
    }
}
