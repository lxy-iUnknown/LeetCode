package com.lxy.leetcode.simulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;

public class MagicStringTest {

    /**
     * <a href="https://oeis.org/A000002">Kolakoski sequence</a> state: x and y<br>
     * <a href="https://oeis.org/A156077">A156077 sequence</a> state: sum
     */
    private static class MagicStringState {
        private int x = -1;
        private int y = -1;
        private int sum = 0;

        public void next() {
            int result = (x & 1) == 0 ? 2 : 1;
            int f = y & ~(y + 1);
            x ^= f;
            y = (y + 1) | (f & (x >> 1));
            sum += result;
        }
    }

    private static int magicString(int n) {
        MagicStringState state = new MagicStringState();
        for (int i = 1; i <= n; i++) {
            state.next();
        }
        return 2 * n - state.sum;
    }

    public static IntStream arguments() {
        return IntStream.rangeClosed(1, 200);
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void magicStringTest(int n) {
        Assertions.assertEquals(magicString(n), MagicString.magicalString(n));
    }
}
