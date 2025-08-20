package com.lxy.leetcode.string;

/**
 * <a href="https://leetcode.cn/problems/1-bit-and-2-bit-characters/">1比特与2比特字符</a>
 */
public class IsOneBitCharacter {
    public static boolean isOneBitCharacter(int[] bits) {
        var result = false;
        var i = 0;
        while (i < bits.length) {
            var bit = bits[i++];
            if (bit == 0) {
                // One-bit character
                result = true;
            } else {
                // Two-bit character
                i++;
                result = false;
            }
        }
        return result;
    }
}
