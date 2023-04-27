package com.lxy.leetcode.array1d;

import java.util.HashMap;

/**
 * <a href="https://leetcode.cn/problems/two-sum">两数之和</a>
 */
public class TwoSum {

    public static int[] twoSum(int[] numbers, int target) {
        int length = numbers.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static int[] twoSumHashMap(int[] numbers, int target) {
        int length = numbers.length;
        HashMap<Integer, Integer> map = new HashMap<>(length);
        for (int i = 0; i < length; i++) {
            // 注意：必须先检查后插入，否则当number = target / 2时会出现错误
            int number = numbers[i];
            int another = target - number;
            if (map.containsKey(another)) {
                return new int[]{i, map.get(another)};
            }
            map.put(number, i);
        }
        return null;
    }
}
