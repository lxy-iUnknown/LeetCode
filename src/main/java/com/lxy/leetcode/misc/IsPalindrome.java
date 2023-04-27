package com.lxy.leetcode.misc;

/**
 * <a href="https://leetcode.cn/problems/palindrome-number/">回文数</a>
 */
public class IsPalindrome {
    public static boolean isPalindrome(int number) {
        if (number < 0) {
            return false;
        }
        long left = number;
        int right = 0;
        while (number > 0) {
            int temp = number / 10;
            right = right * 10 + number - temp * 10;
            number = temp;
        }
        return left == right;
    }

    public static boolean isPalindromeOptimized(int number) {
        if (number < 0) {
            return false;
        }
        // The following code is not working when number is a power of 10
        if ((number % 10) == 0 && (number != 0)) {
            return false;
        }
        int reversed = 0;
        while (number > reversed) {
            int temp = number / 10;
            reversed = reversed * 10 + number - temp * 10;
            number = temp;
        }
        return number == reversed || number == reversed / 10;
    }
}
