package com.lxy.leetcode.simulation;

import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;

public class MinimumOperations {

    private static int subtractNumberAndUpdateIndex(int[] numbers, int index, int length) {
        int oldNumber = numbers[index];
        for (int i = index; i < length; i++) {
            int newNumber = numbers[i] - oldNumber;
            // Increment zero index
            if (newNumber == 0) {
                index++;
            }
            numbers[i] = newNumber;
        }
        return index;
    }

    public static int minimumOperations(int[] numbers) {
        int length = numbers.length;
        Arrays.sort(numbers, 0, length);
        int index = 0;
        int count = 0;
        // First non-zero index
        while (index < length && numbers[index] == 0) {
            index++;
        }
        while (index < length) {
            index = subtractNumberAndUpdateIndex(numbers, index, length);
            count++;
        }
        return count;
    }

    public static int minimumOperationsOptimized(int[] numbers) {
        // 0 <= numbers[i] <= 100
        HashSet<Integer> set = new HashSet<>(100);
        for (int number : numbers) {
            if (number != 0) {
                set.add(number);
            }
        }
        return set.size();
    }
}
