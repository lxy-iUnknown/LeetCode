package com.lxy.leetcode.array1d;

import java.util.Arrays;
import java.util.HashMap;
import java.util.function.BiFunction;

/**
 * <a href="https://leetcode.cn/problems/intersection-of-two-arrays-ii/">两个数组的交集</a>
 */
public class Intersect {

    private static final BiFunction<Integer, Integer, Integer> BUILD_COUNTER =
            (_, value) -> value == null ? 1 : value + 1;

    private static int[] intersectHashMap(int[] numbers1, int[] numbers2, int length1, int length2) {
        if (length1 > length2) {
            return intersectHashMap(numbers2, numbers1, length2, length1);
        }
        var counter = new HashMap<Integer, Integer>(length1);
        var result = new int[length1];
        var count = new MutableInteger(0);
        for (var i = 0; i < length1; i++) {
            counter.compute(numbers1[i], BUILD_COUNTER);
        }
        for (var i = 0; i < length2; i++) {
            counter.computeIfPresent(numbers2[i], (key, value) -> {
                result[count.value++] = key;
                return --value != 0 ? value : null;
            });
        }
        return Arrays.copyOfRange(result, 0, count.value);
    }

    public static int[] intersect(int[] numbers1, int[] numbers2) {
        var length1 = numbers1.length;
        var length2 = numbers2.length;
        Arrays.sort(numbers1, 0, length1);
        Arrays.sort(numbers2, 0, length2);
        var temp = new int[Math.min(length1, length2)];
        var count = 0;
        var i = 0;
        var j = 0;
        while (i < length1 && j < length2) {
            var number1 = numbers1[i];
            var number2 = numbers2[j];
            if (number1 == number2) {
                i++;
                j++;
                temp[count++] = number1;
            } else if (number1 < number2) {
                i++;
            } else {
                j++;
            }
        }
        return Arrays.copyOfRange(temp, 0, count);
    }

    public static int[] intersectHashMap(int[] numbers1, int[] numbers2) {
        return intersectHashMap(numbers1, numbers2, numbers1.length, numbers2.length);
    }

    private static class MutableInteger {
        private int value;

        public MutableInteger(int value) {
            this.value = value;
        }
    }
}
