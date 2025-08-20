package com.lxy.leetcode.simulation;

import com.lxy.leetcode.util.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.FieldSource;

import java.util.List;

public class MagicStringTest {
    public static final List<Integer> ARGUMENTS = TestUtil.generateRangeArray(1, 200);

    private static int magicString(int n) {
        var state = new MagicStringState();
        for (var i = 1; i <= n; i++) {
            state.next();
        }
        return 2 * n - state.sum;
    }

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void magicStringTest(int n) {
        Assertions.assertEquals(magicString(n), MagicString.magicalString(n));
    }

    /**
     * <a href="https://oeis.org/A000002">Kolakoski sequence</a> state: x and y<br>
     * <a href="https://oeis.org/A156077">A156077 sequence</a> state: sum
     */
    private static class MagicStringState {
        private int x = -1;
        private int y = -1;
        private int sum = 0;

        public void next() {
            var result = (x & 1) == 0 ? 2 : 1;
            var f = y & ~(y + 1);
            x ^= f;
            y = (y + 1) | (f & (x >> 1));
            sum += result;
        }
    }
}
