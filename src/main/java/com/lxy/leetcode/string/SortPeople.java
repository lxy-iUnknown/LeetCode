package com.lxy.leetcode.string;

import java.util.Arrays;
import java.util.HashMap;

/**
 * <a href="https://leetcode.cn/problems/sort-the-people/">按身高排序</a>
 */
public class SortPeople {

    public static String[] sortPeople(String[] names, int[] heights) {
        int length = names.length;
        // Name is not unique, but height is unique
        HashMap<Integer, String> heightToNameMap = new HashMap<>(length);
        for (int i = 0; i < length; i++) {
            heightToNameMap.put(heights[i], names[i]);
        }
        Arrays.sort(heights, 0, length);
        for (int i = length - 1; i >= 0; i--) {
            names[length - i - 1] = heightToNameMap.get(heights[i]);
        }
        return names;
    }
}
