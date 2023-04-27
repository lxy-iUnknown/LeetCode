package com.lxy.leetcode.array1d;

public class DecodeArray {
    public static int[] decodeArray(int[] encoded, int first) {
        int length = encoded.length;
        int[] decoded = new int[length + 1];
        decoded[0] = first;
        for (int i = 1; i <= length; i++) {
            int result = encoded[i - 1] ^ first;
            decoded[i] = result;
            first = result;
        }
        return decoded;
    }
}
