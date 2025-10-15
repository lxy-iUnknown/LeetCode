package com.lxy.leetcode.string;

public record StringRange(int start, int end) {
    boolean isEmpty() {
        return start == end;
    }
}
