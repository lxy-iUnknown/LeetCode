package com.lxy.leetcode.simulation;

public class FindArrayConcatValue {

    /**
     * Concatenate two numbers, e.g. concat(123, 45678) = 12345678<br>
     * Linear search is faster than binary search because both number1
     * and number2 are small. See implNote of {@link jdk.internal.util.DecimalDigits#stringSize(int)}
     *
     * @param number1 First number
     * @param number2 Second number
     * @return Concatenated number
     */
    private static long concatValue(long number1, int number2) {
        var temp = number2;
        // Avoid bug when number2 == 0
        while (temp >= 10) {
            temp /= 10;
            number1 *= 10;
        }
        return number1 * 10 + number2;
    }

    public static long findArrayConcatValue(int[] numbers) {
        var low = 0;
        var high = numbers.length - 1;
        long result = 0;
        while (low < high) {
            result += concatValue(numbers[low++], numbers[high--]);
        }
        if (low == high) {
            result += numbers[low];
        }
        return result;
    }
}