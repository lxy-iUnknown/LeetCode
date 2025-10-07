package com.lxy.leetcode.string;

import java.util.stream.Stream;

public class CountAndSayTableGenerator {

    private static String computeNext(String str) {
        var sb = new StringBuilder();
        var start = 0;
        var i = 0;
        var length = str.length();
        while (i < length) {
            var startChar = str.charAt(start);
            while (i < length && str.charAt(i) == startChar) {
                i++;
            }
            sb.append(i - start).append(startChar);
            start = i;
        }
        return sb.toString();
    }

    public static String[] generate(int size) {
        return Stream.iterate("1", CountAndSayTableGenerator::computeNext)
                .limit(size)
                .toArray(String[]::new);
    }
}
