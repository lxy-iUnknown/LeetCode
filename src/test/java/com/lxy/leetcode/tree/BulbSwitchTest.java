package com.lxy.leetcode.tree;

import com.lxy.leetcode.simulation.BulbSwitch;
import com.lxy.leetcode.util.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.FieldSource;

import java.util.List;

public class BulbSwitchTest {
    public static final List<Integer> ARGUMENTS = TestUtil.generateRangeArray(0, 100);

    private static int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void bulbSwitchTest(int n) {
        Assertions.assertEquals(bulbSwitch(n), BulbSwitch.bulbSwitch(n));
    }

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void bulbSwitchOptimizedTest(int n) {
        Assertions.assertEquals(bulbSwitch(n), BulbSwitch.bulbSwitchOptimized(n));
    }
}
