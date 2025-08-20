package com.lxy.leetcode.misc;

/**
 * <a href="https://leetcode.cn/problems/decode-the-message/">解密消息</a>
 */
public class DecodeMessage {
    public static String decodeMessage(String key, String message) {
        // Index to ASCII mapping
        var table = new char[26];
        var count = 'a';
        // Build mapping table
        for (var i = 0; i < key.length(); i++) {
            // ' ' = 32, 'a' ~ 'z' = 97 ~ 122
            var index = key.charAt(i) - 'a';
            if (index >= 0 && table[index] == 0 /* mapping not exists */) {
                table[index] = count++;
            }
            // Mapping table is full
            if (count > 'z') {
                break;
            }
        }
        // Decode message
        var result = message.toCharArray();
        var length = result.length;
        for (var i = 0; i < length; i++) {
            var ch = result[i];
            if (ch != ' ') {
                // Use mapping
                ch = table[ch - 'a'];
            }
            result[i] = ch;
        }
        return new String(result, 0, length);
    }
}
