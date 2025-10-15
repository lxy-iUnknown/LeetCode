package com.lxy.leetcode.ref;

public class BooleanRef {
    public boolean value;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BooleanRef that)) return false;
        return value == that.value;
    }

    @Override
    public String toString() {
        return "BooleanRef{" + "value=" + value + '}';
    }
}
