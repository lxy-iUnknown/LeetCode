package com.lxy.leetcode.dp;

import com.lxy.leetcode.util.Constants;

/**
 * <a href="https://leetcode.cn/problems/qing-wa-tiao-tai-jie-wen-ti-lcof">青蛙跳台阶问题</a>
 */
public class NumWays {

    public static int numWays(int n) {
        switch (n) {
            case 0, 1 -> {
                return 1;
            }
            default -> {
                int dp_1 = 1, dp_2 = 1;
                for (int i = 2; i <= n; i++) {
                    int dp = dp_1 + dp_2;
                    // Equivalent to dp = (dp_1 + dp_2) % MODULO
                    if (dp > Constants.MODULO) {
                        dp -= Constants.MODULO;
                    }
                    dp_1 = dp_2;
                    dp_2 = dp;
                }
                return dp_2;
            }
        }
    }
}
