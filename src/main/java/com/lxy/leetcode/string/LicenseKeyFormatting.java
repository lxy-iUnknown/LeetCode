package com.lxy.leetcode.string;

/**
 * <a href="https://leetcode.cn/problems/license-key-formatting/">密钥格式化</a>
 */
public class LicenseKeyFormatting {
    private static char toUpperSimple(char ch) {
        final int LOWER_CASE_MASK = 32;

        // '0' ~ '9' = 48 ~ 57
        // 'A' ~ 'Z' = 65 ~ 90
        // 'a' ~ 'z' = 97 ~ 112
        if (ch > '9') {
            return (char) (ch & ~LOWER_CASE_MASK);
        }
        return ch;
    }

    public static String licenseKeyFormatting(String s, int k) {
        var length = s.length();
        var bufferLength = length * 2 - 1;
        var i = length - 1;
        var j = bufferLength - 1;
        var count = 0;
        var buffer = new char[bufferLength];
        outer:
        while (i >= 0) {
            char ch;
            while ((ch = s.charAt(i--)) == '-') {
                if (i < 0) {
                    break outer;
                }
            }
            if (count >= k) {
                buffer[j--] = '-';
                count = 0;
            }
            buffer[j--] = toUpperSimple(ch);
            count++;
        }
        return new String(buffer, j + 1, bufferLength - j - 1);
    }
}
