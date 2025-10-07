package com.lxy.leetcode.math;

/**
 * <a href="https://leetcode.cn/problems/find-the-k-th-character-in-string-game-i">找出第K个字符I</a>
 */
public class KthCharacter {
    private static char next(char c) {
        return c == 'z' ? 'a' : (char) (c + 1);
    }

    /**
     * f(1) = a, f(2) = n(f(1))<br>
     * f(3) = n(f(1)), f(4) = n(f(2))<br>
     * f(5) = n(f(1)), f(6) = n(f(2)), f(7) = n(f(3)), f(8) = n(f(4))<br>
     * f(n) = a (n = 1), n(f(floor(log2(n - 1)))) (n > 1)
     * */
    public static char kthCharacter(int k) {
        var value = 'a';
        while (k > 1) {
            var floorLog2 = 31 - Integer.numberOfLeadingZeros(k - 1);
            k -= 1 << floorLog2;
            value = next(value);
        }
        return value;
    }

    /**
     * 由上述递推式可得：由于每次循环都会去掉n - 1最高位的1，因此f(n) = next('a', bitCount(n - 1))
     * */
    public static char kthCharacterOptimized(int k) {
        var loopCount = Integer.bitCount(k - 1);
        return (char) ('a' + (loopCount % 26));
    }
}
