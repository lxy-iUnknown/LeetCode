package com.lxy.leetcode.string;

import java.util.HashMap;

/**
 * <a href="https://leetcode.cn/problems/fraction-to-recurring-decimal/">分式化简</a>
 */
public class FractionToDecimal {

    private static String fractionToDecimal(long numerator, long denominator, boolean negative) {
        long quotient, remainder;

        HashMap<Long, Integer> remainderToIndexMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        quotient = numerator / denominator;
        remainder = numerator - quotient * denominator;
        if (negative) {
            sb.append('-');
        }
        sb.append(quotient);
        // Have fraction part
        if (remainder != 0) {
            sb.append('.');
            // Record insertion position
            remainderToIndexMap.put(remainder, sb.length());
            numerator = remainder * 10;
            for (; ; ) {
                quotient = numerator / denominator;
                remainder = numerator - quotient * denominator;
                sb.append((char)(quotient + '0'));
                Integer temp = remainderToIndexMap.get(remainder);
                if (temp == null) {
                    // Such remainder does not exist
                    // Record insertion position
                    remainderToIndexMap.put(remainder, sb.length());
                } else {
                    // Contains such a remainder, so we reached at the end of a repetend
                    sb.insert((int) temp, '(').append(')');
                    break;
                }
                // Division complete
                if (remainder == 0) {
                    break;
                }
                numerator = remainder * 10;
            }
        }
        return sb.toString();
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        // Special case
        if (numerator == 0) {
            return "0";
        }
        return fractionToDecimal(Math.abs((long)numerator),
                Math.abs((long)denominator),
                (numerator ^ denominator) < 0);
    }
}
