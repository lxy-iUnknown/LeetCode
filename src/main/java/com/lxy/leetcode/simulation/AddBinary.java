package com.lxy.leetcode.simulation;

/**
 * <a href="https://leetcode.cn/problems/add-binary">二进制求和</a>
 */
public class AddBinary {

    private static class Carry {
        private int value;

        private boolean hasCarry() {
            return value != 0;
        }
    }

    // '0' = 48(0b110000), lowest bit is 0
    // '1' = 49(0b110001), lowest bit is 1
    private static int toBinaryDigit(char digit) {
        return digit & 1;
    }

    // '0' = 48(0b110000), lowest bit is 0
    // '1' = 49(0b110001), lowest bit is 1
    private static char fromBinaryDigit(int digit) {
        return (char) ('0' | digit);
    }

    private static int binaryAdd(int a, int b, /* out */ Carry carry) {
        // S = A ^ B
        // C = A * B
        carry.value = a & b;
        return a ^ b;
    }

    private static int binaryAddWithCarry(int a, int b, /* ref */ Carry carry) {
        // High bit is carry, low bit is sum
        int sum = a + b + carry.value;
        carry.value = sum >>> 1;
        return sum & 1;
    }

    private static void addRestBinaryDigits(int i, Carry carry, String s, char[] digits) {
        if (carry.hasCarry()) {
            // Perform xxx plus one
            int k = i--;
            while (i >= 0) {
                digits[k--] = fromBinaryDigit(binaryAdd(
                        toBinaryDigit(s.charAt(i--)),
                        carry.value, carry));
            }
        } else {
            s.getChars(0, i, digits, 1);
        }
    }

    public static String addBinary(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();
        int newLength = Math.max(length1, length2) + 1;

        char[] digits = new char[newLength];
        Carry carry = new Carry();
        int i = length1, j = length2, k = newLength;
        while (i > 0 && j > 0) {
            int digit1 = toBinaryDigit(s1.charAt(--i));
            int digit2 = toBinaryDigit(s2.charAt(--j));
            digits[--k] = fromBinaryDigit(binaryAddWithCarry(digit1, digit2, carry));
        }
        if (i > 0) {
            addRestBinaryDigits(i, carry, s1, digits);
        } else {
            addRestBinaryDigits(j, carry, s2, digits);
        }
        // Write last carry
        if (carry.hasCarry()) {
            digits[0] = '1';
            return new String(digits, 0, newLength);
        } else {
            return new String(digits, 1, newLength - 1);
        }
    }
}
