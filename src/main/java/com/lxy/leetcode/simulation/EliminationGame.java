package com.lxy.leetcode.simulation;

/**
 * <a href="https://leetcode.cn/problems/elimination-game/">消除游戏</a>
 */
public class EliminationGame {
    /**
     * 消除游戏算法推导：<br>
     * 设f(1...n)为从左往右不断消除后剩下的元素，b(1...n)为从右往左后不断消除剩下的元素，有以下结论：<br>
     * （1）f(1...n) + b(1...n) = n + 1<br>
     * 证明：将序列1...n中的每个元素映射到一个新的序列n...1，显然映射关系为i -> (n + 1) - i，
     * 显然f(1...n) = b(n...1)<br>
     * 设f(1...n) = r, 又b(n...1)中剩余元素<b>所在位置</b>和b(1...n)剩余元素<b>所在位置</b>相同，
     * 于是b(1...n) = (n + 1) - r，即f(1...n) + b(1...n) = n + 1<br>
     * （2）f(1...n) = 2b(1...n / 2)<br>
     * 证明：对1...n进行一次消除操作后剩余序列应为2,4...n / 2，提出公因数2可得2 * (1...n / 2)。
     * 然后接下来需要做一次从右往左的不断消除，即f(1...n) = 2b(1...n / 2)<br>
     * 将（1）式代入（2）式消去b(1...n)，可得f(1...n) = 2(n / 2 + 1 - 2f(1...n / 2))，
     * 简写为f(n) = 2(n / 2 + 1 - 2f(n / 2))<br>
     * 注：以上推导过程中的除号（/）为向下取整，此事仅对n&gt;1成立
     * @param n 数字范围
     * @return 最后剩下的数字
     */
    public static int lastRemaining(int n) {
        if (n == 1) {
            return 1;
        }
        n /= 2;
        return 2 * (n + 1 - lastRemaining(n));
    }
}
