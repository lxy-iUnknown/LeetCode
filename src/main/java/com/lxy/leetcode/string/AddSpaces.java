package com.lxy.leetcode.string;

/**
 * <a href="https://leetcode.cn/problems/adding-spaces-to-a-string/">向字符串添加空格</a>
 */
public class AddSpaces {
    public static String addSpaces(String s, int[] spaces) {
        var length = s.length();
        var spaceCount = spaces.length;
        var totalLength = length + spaceCount;
        var result = new char[totalLength];
        var srcIndex = 0;
        var destIndex = 0;
        for (var space : spaces) {
            // Copy characters
            s.getChars(srcIndex, space, result, destIndex);
            destIndex += space - srcIndex;
            result[destIndex++] = ' ';
            srcIndex = space;
        }
        // Copy last characters
        s.getChars(srcIndex, length, result, destIndex);
        return new String(result, 0, totalLength);
    }
}
