package com.lxy.leetcode.tree;

import com.lxy.leetcode.simulation.BulbSwitch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;

public class BulbSwitchTest {
    public static IntStream arguments() {
        return IntStream.rangeClosed(0, 100);
    }

    private static int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void bulbSwitchTest(int n) {
        Assertions.assertEquals(bulbSwitch(n), BulbSwitch.bulbSwitch(n));
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void bulbSwitchOptimizedTest(int n) {
        Assertions.assertEquals(bulbSwitch(n), BulbSwitch.bulbSwitchOptimized(n));
    }
}
