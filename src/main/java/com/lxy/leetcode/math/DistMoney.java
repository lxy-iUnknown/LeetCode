package com.lxy.leetcode.math;

public class DistMoney {
    public static int distMoney(int money, int children) {
        // 例一：30, 4 -> 8, 8, 8, 6
        // 例二：60, 4 -> 8, 8, 8, 36
        // 例三：28, 4 -> 8, 8, 9, 5
        // 例四：32, 4 -> 8, 8, 8, 8
        // 例五：28, 5 -> 8, 8, 8, 1, 3
        // 例六：17, 2 -> 8, 9

        // 判断是否小于最小值
        if (money < children) {
            return -1;
        }
        // 判断是否大于最大值
        if (money > 8 * children) {
            return children - 1;
        }
        money -= children;
        // 分配尽可能多的7
        var sevens = money / 7;
        if (sevens == 0) {
            // 不够分
            return 0;
        }
        var remainder = money - sevens * 7;
        // 不是儿童都分到8
        // 至少有一个儿童没分到8，即若干个8和若干个1
        if (remainder == 3) {
            // 余数为3
            var ones = children - sevens;
            // 如果有超过2个1，则将1, 4拆分成2, 3
            // 如果只有一个1，则将8, 4拆分成9, 3
            if (ones >= 2) {
                return sevens;
            }
            return sevens - 1;
        } else {
            return sevens;
        }
    }
}
