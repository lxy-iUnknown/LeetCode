package com.lxy.leetcode.array1d;

/**
 * <a href="https://leetcode.cn/problems/decode-xored-array/">解码异或后的数组</a>
 */
public class DecodeArray {
    public static int[] decodeArray(int[] encoded, int first) {
        var length = encoded.length;
        var decoded = new int[length + 1];
        decoded[0] = first;
        for (var i = 1; i <= length; i++) {
            var result = encoded[i - 1] ^ first;
            decoded[i] = result;
            first = result;
        }
        return decoded;
    }
}
