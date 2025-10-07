package com.lxy.leetcode.util;

import java.util.Objects;

public class TwoSet<T> {
    private final T first;
    private final T second;

    public TwoSet(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public static <T> TwoSet<T> of(T first, T second) {
        return new TwoSet<>(first, second);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof TwoSet<?> twoSet)) return false;
        return (Objects.equals(first, twoSet.first) && Objects.equals(second, twoSet.second)) ||
                        (Objects.equals(first, twoSet.second) && Objects.equals(second, twoSet.first));
    }

    @Override
    public String toString() {
        return "TwoSet{" + "first=" + first + ", second=" + second + '}';
    }
}
