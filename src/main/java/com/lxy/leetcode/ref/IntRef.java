package com.lxy.leetcode.ref;

public class IntRef {
    public int value;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof IntRef intRef)) return false;
        return value == intRef.value;
    }

    @Override
    public String toString() {
        return "IntRef{" + "value=" + value + '}';
    }
}
