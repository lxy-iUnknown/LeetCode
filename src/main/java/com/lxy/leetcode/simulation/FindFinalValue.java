package com.lxy.leetcode.simulation;

import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;

/**
 * <a href="https://leetcode.cn/problems/keep-multiplying-found-values-by-two">将找到的值乘以2</a>
 */
public class FindFinalValue {
    public static int findFinalValue(int[] numbers, int original) {
        int length = numbers.length;
        Arrays.sort(numbers, 0, length);
        int index = 0;
        while ((index = Arrays.binarySearch(numbers, index, length, original)) >= 0) {
            original *= 2;
        }
        return original;
    }

    public static int findFinalValueHashSet(int[] numbers, int original) {
        // 1 <= numbers[i], original <= 1000
        HashSet<Integer> set = new HashSet<>(1000);
        for (int number : numbers) {
            set.add(number);
        }
        while (set.contains(original)) {
            original *= 2;
        }
        return original;
    }

    public static int findFinalValueBitSet(int[] numbers, int original) {
        // 1 <= numbers[i], original <= 1000
        BitSet set = new BitSet(1000);
        for (int number : numbers) {
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
        int bits = 0;
        for (int number : numbers) {
            int ratio = number / original;
            int remainder = number - ratio * original;
            // Remainder != 0 and ratio is a power of two
            if ((remainder | (ratio & (ratio - 1))) == 0) {
                bits |= ratio;
            }
        }
        // Find consecutive one count
        return original << Integer.numberOfTrailingZeros(~bits);
    }
}
