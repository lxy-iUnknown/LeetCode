package com.lxy.leetcode.misc;

/**
 * <a href="https://leetcode.cn/problems/decode-the-message/">解密消息</a>
 */
public class DecodeMessage {
    public static String decodeMessage(String key, String message) {
        // Index to ASCII mapping
        char[] table = new char[26];
        int count = 'a';
        // Build mapping table
        for (int i = 0; i < key.length(); i++) {
            // ' ' = 32, 'a' ~ 'z' = 97 ~ 122
            int index = key.charAt(i) - 'a';
            if (index >= 0 && table[index] == 0 /* mapping not exists */) {
                table[index] = (char) count++;
            }
            // Mapping table is full
            if (count > 'z') {
                break;
            }
        }
        // Decode message
        char[] result = message.toCharArray();
        int length = result.length;
        for (int i = 0; i < length; i++) {
            char ch = result[i];
            if (ch != ' ') {
                // Use mapping
                ch = table[ch - 'a'];
            }
            result[i] = ch;
        }
        return new String(result, 0, length);
    }
}
