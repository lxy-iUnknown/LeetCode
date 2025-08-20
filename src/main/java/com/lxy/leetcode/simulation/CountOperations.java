package com.lxy.leetcode.simulation;

/**
 * <a href="https://leetcode.cn/problems/count-operations-to-obtain-zero/">得到零的操作数</a>
 */
public class CountOperations {
    public static int countOperations(int number1, int number2) {
        var count = 0;
        while (number1 != 0 && number2 != 0) {
            if (number1 > number2) {
                number1 -= number2;
            } else {
                number2 -= number1;
            }
            count++;
        }
        return count;
    }

    // 将多次减法合并为除法和取余
    public static int countOperationsOptimized(int number1, int number2) {
        // Ensure number1 > number2
        if (number1 < number2) {
            var temp = number1;
            number1 = number2;
            number2 = temp;
        }
        var count = 0;
        while (number1 != 0 && number2 != 0) {
            var div = number1 / number2;
            var rem = number1 - div * number2;
            count += div;
            number1 = number2;
            number2 = rem;
        }
        return count;
    }
}
