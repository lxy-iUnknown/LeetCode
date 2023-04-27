package com.lxy.leetcode.simulation;

import java.util.BitSet;

/**
 * <a href="https://leetcode.cn/problems/bulb-switcher/">灯泡开关</a>
 */
public class BulbSwitch {
    // Simulation
    public static int bulbSwitch(int n) {
        switch (n) {
            case 0 -> {
                return 0;
            }
            case 1, 2 -> {
                return 1;
            }
            default -> {
                BitSet bitSet = new BitSet(n);
                // First and second round
                for (int i = 1; i <= n; i += 2) {
                    bitSet.set(i - 1);
                }
                for (int i = 3; i <= n; i++) {
                    for (int j = i; j <= n; j += i) {
                        bitSet.flip(j - 1);
                    }
                }
                return bitSet.cardinality();
            }
        }
    }

    /**
     * 返回灯泡进行一系列开关操作后处于打开状态的灯泡数<br>
     * 显然，若某个灯泡的总操作次数为奇数，则该灯泡最后处于打开状态，否则处于关闭状态
     * （由于一开始灯泡都是关闭状态）。根据操作规则可知，如果第i个灯泡在第k轮会被操作，则k一定是i的因数，那么问题就转化为
     * 在[1, n]的整数中，因数个数为奇数的整数个数。<br>
     * 由于因数总是成对出现，也就是说，如果k是n的因数，则n / k也是n的因数。要使因数个数为奇数，
     * 就需要存在某一个k，使得k = n / k（即某一对因数是同一个数），即存在一个数k，使得n = k<sup>2</sup>
     * ，即n是完全平方数。而[1, n]的整数中完全平方数有floor(sqrt(n))个（把[1,
     * floor(sqrt(n))]中的数平方即可得到而[1, n]的整数中的所有完全平方数）
     * @param n 灯泡数
     * @return 处于打开状态的灯泡数
     */
    public static int bulbSwitchOptimized(int n) {
        return (int) Math.sqrt(n);
    }
}
