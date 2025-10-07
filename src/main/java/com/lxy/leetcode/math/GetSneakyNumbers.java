package com.lxy.leetcode.math;

/**
 * <a href="https://leetcode.cn/problems/the-two-sneaky-numbers-of-digitville/">数字小镇中的捣蛋鬼</a>
 */
public class GetSneakyNumbers {
    /**
     * 设S<sub>n</sub> = 0<sup>2</sup> + 1<sup>2</sup> + ... + (n - 1)<sup>2</sup><br>
     * 显然：
     * 1<sup>3</sup> - 0<sup>3</sup> = 3 * 0<sup>2</sup> + 3 * 0 + 1<br>
     * 2<sup>3</sup> - 1<sup>3</sup> = 3 * 1<sup>2</sup> + 3 * 1 + 1<br>
     * 3<sup>3</sup> - 2<sup>3</sup> = 3 * 2<sup>2</sup> + 3 * 2 + 1<br>
     * ...<br>
     * n<sup>3</sup> - (n - 1)<sup>3</sup> = 3(n - 1)<sup>2</sup> + 3(n - 1) + 1<br>
     * 相加得：<br>
     * n<sup>3</sup> = 3S<sub>n</sub> + 3n(n - 1) / 2 + n<br>
     * 于是S<sub>n</sub> = (n<sup>3</sup> - 3n(n - 1) / 2 - n) / 3 = n(n - 1)(2n - 1) / 6<br>
     * 设：n = length - 2, s = sum(array), s2 = sum(array<sup>2</sup>), a = s - n(n - 1) / 2, b = s2 - (n<sup>3</sup> - 3n(n - 1) / 2 - n) / 3<br>
     * 由题意可得方程：x + y = a, x<sup>2</sup> + y<sup>2</sup> = b<br>
     * 解得：<br>
     * x<sub>1</sub> = (2a - sqrt(8b - 4a<sup>2</sup>)) / (2 * 2)<br>
     * x<sub>2</sub> = (2a + sqrt(8b - 4a<sup>2</sup>)) / (2 * 2)<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;= (2a + sqrt(8b - 4a<sup>2</sup>)) / 4<br>
     */
    public static int[] getSneakyNumbers(int[] nums) {
        var n = nums.length - 2;
        var sum = 0;
        var sum2 = 0;
        for (int num : nums) {
            sum += num;
            sum2 += num * num;
        }
        var a = sum - (n * (n - 1) >>> 1);
        var b = sum2 - n * (n - 1) * (2 * n - 1) / 6;
        var x = (2 * a - (int) Math.sqrt(8 * b - 4 * a * a)) >>> 2;
        return new int[]{x, a - x};
    }
}
