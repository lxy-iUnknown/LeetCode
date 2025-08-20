package com.lxy.leetcode.simulation;

public class DistributeCandies {
    private static int sum(int n, int k) {
        return k + 1 + n * k * (k + 1) / 2;
    }

    /**
     * 糖果分配表：
     * <table border="1">
     *     <tr style="text-align: center">
     *         <td/><td>c = 1</td><td>c = 2</td><td>...</td><td>c = k</td>
     *     </tr>
     *     <tr style="text-align: center">
     *         <td>r = 0&nbsp;</td><td>1</td><td>2</td><td>...</td><td>k</td>
     *     </tr>
     *     <tr style="text-align: center">
     *         <td>r = 1&nbsp;</td>
     *         <td>k + 1&nbsp;</td><td>k + 2&nbsp;</td><td>...&nbsp;</td><td>2k</td>
     *     </tr>
     *     <tr style="text-align: center">
     *         <td>r = 2&nbsp;</td>
     *         <td>2k + 1&nbsp;</td><td>2k + 2&nbsp;</td><td>...&nbsp;</td><td>3k</td>
     *     </tr>
     *     <tr style="text-align: center">
     *         <td>r = 3&nbsp;</td>
     *         <td>3k + 1&nbsp;</td><td>3k + 2&nbsp;</td><td>...&nbsp;</td><td>4k</td>
     *     </tr>
     *     <tr style="text-align: center">
     *         <td>...</td><td>...</td><td>...&nbsp;</td><td>...&nbsp;</td><td>...</td>
     *     </tr>
     *     <tr style="text-align: center">
     *         <td>r = n&nbsp;</td>
     *         <td>nk + 1&nbsp;</td><td>nk + 2&nbsp;</td><td>...&nbsp;</td><td>(n + 1)k</td>
     *     </tr>
     * </table>
     * 总共可以分配的次数p = floor(-1 / 2 + sqrt(2 * n + 1 / 4))<br>
     * 完整的分发回合数r = floor(p / k)，剩余的人数c = p % k<br>
     * 每一列的和为c(k + 1) + r * k(k + 1) / 2<br>
     */
    public static int[] distributeCandies(int n, int k) {
        var dist = new int[k];
        var limit = (int) (-1.0 / 2 + Math.sqrt(2 * n + 1.0 / 4));
        var round = limit / k;
        var rest = limit - round * k;
        int start;

        start = sum(k, round);
        for (var i = 0; i < rest; i++) {
            dist[i] = start;
            n -= start;
            start += round + 1;
        }
        start = sum(k, round - 1) + rest * round;
        for (var i = rest; i < k; i++) {
            dist[i] = start;
            n -= start;
            start += round;
        }
        dist[rest] += n;
        return dist;
    }
}
