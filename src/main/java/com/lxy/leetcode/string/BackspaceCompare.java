package com.lxy.leetcode.string;

public class BackspaceCompare {
    public static boolean backspaceCompare(String s, String t) {
        var i = s.length() - 1;
        var j = t.length() - 1;
        while (i >= 0 || j >= 0) {
            var iCount = 0;
            var jCount = 0;
            // 模拟删除字符（出栈入栈），直到#号数目为零
            while (i >= 0) {
                if (s.charAt(i--) == '#') {
                    iCount++;
                } else {
                    iCount--;
                }
                if (iCount < 0) {
                    i++;
                    break;
                }
            }
            while (j >= 0) {
                if (t.charAt(j--) == '#') {
                    jCount++;
                } else {
                    jCount--;
                }
                if (jCount < 0) {
                    j++;
                    break;
                }
            }
            if (i < 0 && j < 0) {
                // 如果两个指针都走到头，说明都是空字符，则相等
                return true;
            } else if (i < 0 || j < 0 || s.charAt(i) != t.charAt(j)) {
                // 字符不相等
                return false;
            } else {
                i--;
                j--;
            }
        }
        return true;
    }
}
