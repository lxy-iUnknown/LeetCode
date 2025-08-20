package com.lxy.leetcode.array1d;

import java.util.HashMap;

/**
 * <a href="https://leetcode.cn/problems/two-sum/">两数之和</a>
 */
public class TwoSum {

    public static int[] twoSum(int[] numbers, int target) {
        var length = numbers.length;
        for (var i = 0; i < length - 1; i++) {
            for (var j = i + 1; j < length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static int[] twoSumHashMap(int[] numbers, int target) {
        var length = numbers.length;
        var map = new HashMap<Integer, Integer>(length);
        for (var i = 0; i < length; i++) {
            // 注意：必须先检查后插入，否则当number = target / 2时会出现错误
            var number = numbers[i];
            var another = target - number;
            if (map.containsKey(another)) {
                return new int[]{i, map.get(another)};
            }
            map.put(number, i);
        }
        return null;
    }
}
