package com.lxy.leetcode.math;

public class MinPartitions {

    // 要想让部分数最小，每个部分要尽可能大
    // 不难证明：a + b - min(a, b) = max(a, b)
    // 13579 = 1 * 10000 + 3579 -> 1
    //       = 1 * 10000 + 3 * 1000 + 579
    //       = 1 * 11000 + 2 * 1000 + 579 -> 1 + 3 - min(1, 3) = max(1, 3)
    //       = 1 * 11000 + 2 * 1000 + 5 * 100 + 79
    //       = 1 * 11100 + 2 * 1100 + 2 * 100 + 79 -> max(1, 3) + 5 - min(max(1, 3), 5) = max(max(1, 3), 5) = max(1, 3, 5)
    //       = 1 * 11100 + 2 * 1100 + 2 * 100 + 7 * 10 + 9
    //       = 1 * 11110 + 2 * 1110 + 2 * 110 + 2 * 10 + 9 -> max(1, 3, 5) + 7 - min(max(1, 3, 5), 7) = max(max(1, 3, 5), 7) = max(1, 3, 5, 7)
    //       = 1 * 11110 + 2 * 1110 + 2 * 110 + 2 * 10 + 9 * 1
    //       = 1 * 11111 + 2 * 1111 + 2 * 111 + 2 * 11 + 2 * 1 -> max(1, 3, 5, 7) + 9 - min(max(1, 3, 5, 7), 9) = max(max(1, 3, 5, 7, 9)) = max(1, 3, 5, 7, 9)
    public static int minPartitions(String n) {
        var max = Integer.MIN_VALUE;
        for (var i = 0; i < n.length(); i++) {
            max = Math.max(max, n.charAt(i));
        }
        return max - '0';
    }
}
