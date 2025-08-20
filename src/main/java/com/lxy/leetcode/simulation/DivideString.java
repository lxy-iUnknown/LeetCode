package com.lxy.leetcode.simulation;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/divide-a-string-into-groups-of-size-k/">将字符串拆分为若干长度为k的组</a>
 */
public class DivideString {
    public static String[] divideString(String s, int k, char fill) {
        var length = s.length();
        var count = length / k;
        var rest = length - count * k;
        var arraySize = count + (rest == 0 ? 0 : 1);
        // Allocate string array
        var result = new String[arraySize];
        int i;
        // Divide string
        for (i = 0; i < count; i++) {
            result[i] = s.substring(i * k, (i + 1) * k);
        }
        if (rest != 0) {
            // Allocate character buffer
            var buffer = new char[k];
            // Copy rest characters
            s.getChars(count * k, length, buffer, 0);
            // Fill with specified character
            Arrays.fill(buffer, rest, k, fill);
            // Construct rest string
            result[i] = new String(buffer, 0, k);
        }
        return result;
    }
}
