package com.lxy.leetcode.string;

/**
 * <a href="https://leetcode.cn/problems/compare-version-numbers/">比较版本号</a>
 */
public class CompareVersion {
    private static class Part {
        private int value;
    }

    private static int parsePart(String version, int i, int length, Part part) {
        char ch;
        while (i < length && (ch = version.charAt(i++)) != '.') {
            part.value = part.value * 10 + (ch - '0');
        }
        return i;
    }

    public static int compareVersion(String version1, String version2) {
        int length1 = version1.length(), length2 = version2.length();
        int i = 0, j = 0;
        Part part1 = new Part(), part2 = new Part();
        while (i < length1 || j < length2) {
            i = parsePart(version1, i, length1, part1);
            j = parsePart(version2, j, length2, part2);
            // Compare version part
            if (part1.value > part2.value) {
                return 1;
            } else if (part1.value < part2.value) {
                return -1;
            }
            // Reset version part value
            part1.value = 0;
            part2.value = 0;
        }
        return 0;
    }
}
