package com.lxy.leetcode.simulation;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/divide-a-string-into-groups-of-size-k/">将字符串拆分为若干长度为k的组</a>
 */
public class DivideString {
    public static String[] divideString(String s, int k, char fill) {
        int length = s.length();
        int count = length / k;
        int rest = length - count * k;
        int arraySize = count + (rest == 0 ? 0 : 1);
        // Allocate string array
        String[] result = new String[arraySize];
        int i;
        // Divide string
        for (i = 0; i < count; i++) {
            result[i] = s.substring(i * k, (i + 1) * k);
        }
        if (rest != 0) {
            // Allocate character buffer
            char[] buffer = new char[k];
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
