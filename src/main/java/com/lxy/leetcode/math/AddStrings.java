package com.lxy.leetcode.math;

import com.lxy.leetcode.ref.IntRef;

public class AddStrings {

    private static char setCarry(int sum, IntRef carry) {
        if (sum >= 10) {
            sum -= 10;
            carry.value = 1;
        } else {
            carry.value = 0;
        }
        return (char) ('0' + sum);
    }

    public static String addStrings(String num1, String num2) {
        var len1 = num1.length();
        var len2 = num2.length();
        var maxLen = Math.max(len1, len2);
        var chars = new char[maxLen + 1];
        var i = len1 - 1;
        var j = len2 - 1;
        var k = maxLen;
        var carry = new IntRef();
        while (i >= 0 && j >= 0) {
            var c1 = num1.charAt(i--);
            var c2 = num2.charAt(j--);
            chars[k--] = setCarry(c1 + c2 + carry.value - '0' * 2, carry);
        }
        while (i >= 0) {
            if (carry.value == 0) {
                num1.getChars(0, i + 1, chars, 1);
                return new String(chars, 1, maxLen);
            }
            var c = num1.charAt(i--);
            chars[k--] = setCarry(c + carry.value - '0', carry);
        }
        while (j >= 0) {
            if (carry.value == 0) {
                num2.getChars(0, j + 1, chars, 1);
                return new String(chars, 1, maxLen);
            }
            var c = num2.charAt(j--);
            chars[k--] = setCarry(c + carry.value - '0', carry);
        }
        if (carry.value == 0) {
            return new String(chars, 1, maxLen);
        } else {
            chars[0] = '1';
            return new String(chars);
        }
    }
}
