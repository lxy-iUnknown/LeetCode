package com.lxy.leetcode.string;

public class AddSpaces {
    @SuppressWarnings("ForLoopReplaceableByForEach")
    public static String addSpaces(String s, int[] spaces) {
        int length = s.length();
        int spaceCount = spaces.length;
        int totalLength = length + spaceCount;
        char[] result = new char[totalLength];
        int srcIndex = 0, destIndex = 0;
        for (int i = 0; i < spaceCount; i++) {
            int space = spaces[i];
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
