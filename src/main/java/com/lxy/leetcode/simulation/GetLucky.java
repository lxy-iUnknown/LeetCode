package com.lxy.leetcode.simulation;

/**
 * <a href="https://leetcode.cn/problems/sum-of-digits-of-string-after-convert/">字符串转化后的各位数字之和</a>
 */
public class GetLucky {
    private static final byte[] DIGIT_SUM_1_TO_26 = new byte[]{
            // 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
            1, 2, 3, 4, 5, 6, 7, 8, 9, 1,
            // 11, 12, 13, 14, 15, 16, 17, 18, 19, 20
            2, 3, 4, 5, 6, 7, 8, 9, 10, 2,
            // 21, 22, 23, 24, 25, 26
            3, 4, 5, 6, 7, 8,
    };

    private static int digitSum(int number) {
        var sum = 0;
        while (number > 0) {
            var temp = number / 10;
            sum += number - temp * 10;
            number = temp;
        }
        return sum;
    }

    public static int getLucky(String s, int k) {
        // 执行转化和一次转换
        var result = 0;
        for (var i = 0; i < s.length(); i++) {
            result += DIGIT_SUM_1_TO_26[s.charAt(i) - 'a'];
        }
        // 执行剩余的转换
        k--;
        while (k-- > 0 && result >= 10) {
            result = digitSum(result);
        }
        return result;
    }
}
