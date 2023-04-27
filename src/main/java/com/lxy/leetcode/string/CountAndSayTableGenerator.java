package com.lxy.leetcode.string;

import java.util.stream.Stream;

public class CountAndSayTableGenerator {

    private static String countAndSayNext(String str) {
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int i = 0;
        int length = str.length();
        while (i < length) {
            char startChar = str.charAt(start);
            while (i < length && str.charAt(i) == startChar) {
                i++;
            }
            sb.append(i - start).append(startChar);
            start = i;
        }
        return sb.toString();
    }

    public static String[] generate() {
        final int SIZE = 30;

        return Stream.iterate("1",
                        CountAndSayTableGenerator::countAndSayNext)
                .limit(SIZE)
                .toArray(String[]::new);
    }
}
