package com.lxy.leetcode.string;

public class ReverseVowels {
    private static boolean isNonVowel(char ch) {
        final char LOWER_BOUND = 'A';

        final long VOWEL_MASK = (1L << ('A' - LOWER_BOUND)) |
                (1L << ('E' - LOWER_BOUND)) |
                (1L << ('I' - LOWER_BOUND)) |
                (1L << ('O' - LOWER_BOUND)) |
                (1L << ('U' - LOWER_BOUND)) |
                (1L << ('a' - LOWER_BOUND)) |
                (1L << ('e' - LOWER_BOUND)) |
                (1L << ('i' - LOWER_BOUND)) |
                (1L << ('o' - LOWER_BOUND)) |
                (1L << ('u' - LOWER_BOUND));

        // Printable ASCII character: 32 ~ 127
        // 'A' ~ 'Z' = 65 ~ 90
        // 'a' ~ 'z' = 97 ~ 112
        // 127 - 32 = 95, which cannot fit in a long
        // 127 - 65 = 62, which can fit in a long
        return ch < LOWER_BOUND || ((1L << (ch - LOWER_BOUND)) & VOWEL_MASK) == 0;
    }

    private static void swap(char[] array, int a, int b) {
        char temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static String reverseVowels(String s) {
        char[] array = s.toCharArray();
        int length = array.length;
        int i = 0, j = length - 1;
        for (;;) {
            while (i < length && isNonVowel(array[i])) {
                i++;
            }
            while (j >= 0 && isNonVowel(array[j])) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(array, i++, j--);
        }
        return new String(array, 0, length);
    }
}
