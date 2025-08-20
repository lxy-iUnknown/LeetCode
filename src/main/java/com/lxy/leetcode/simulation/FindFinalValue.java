package com.lxy.leetcode.simulation;

import com.lxy.leetcode.util.MathUtil;

import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;

/**
 * <a href="https://leetcode.cn/problems/keep-multiplying-found-values-by-two/">将找到的值乘以2</a>
 */
public class FindFinalValue {
    public static int findFinalValue(int[] numbers, int original) {
        var length = numbers.length;
        Arrays.sort(numbers, 0, length);
        var index = 0;
        while ((index = Arrays.binarySearch(numbers, index, length, original)) >= 0) {
            original *= 2;
        }
        return original;
    }

    public static int findFinalValueHashSet(int[] numbers, int original) {
        // 1 <= numbers[i], original <= 1000
        var set = new HashSet<Integer>(1000);
        for (var number : numbers) {
            set.add(number);
        }
        while (set.contains(original)) {
            original *= 2;
        }
        return original;
    }

    public static int findFinalValueBitSet(int[] numbers, int original) {
        // 1 <= numbers[i], original <= 1000
        var set = new BitSet(1000);
        for (var number : numbers) {
            set.set(number);
        }
        while (set.get(original)) {
            original *= 2;
        }
        return original;
    }

    public static int findFinalValueBitMask(int[] numbers, int original) {
        // 1 <= numbers[i], original <= 1000
        // 2^9 < 1000 < 2^10, so 9 bit is enough
        var bits = 0;
        for (var number : numbers) {
            var ratio = number / original;
            var remainder = number - ratio * original;
            // Remainder == 0 and ratio is a power of two
            if (remainder == 0 && MathUtil.isPowerOfTwo(ratio)) {
                bits |= ratio;
            }
        }
        // Find consecutive one count
        return original << Integer.numberOfTrailingZeros(~bits);
    }
}
