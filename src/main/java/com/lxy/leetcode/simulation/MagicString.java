package com.lxy.leetcode.simulation;

/**
 * <a href="https://leetcode.cn/problems/magical-string/">神奇字符串</a>
 */
public class MagicString {
    /**
     * 求神奇字符串1~n的字串中1的个数。方法：<a href="https://leetcode.cn/problems/magical-string/solutions/1938214/by-endlesscheng-z8o1/">双指针</a>
     * @param n 数据规模n
     * @return 1的个数
     */
    public static int magicalString(int n) {
        if (n <= 3) {
            return 1;
        }
        int count = 1;
        byte[] array = new byte[n];
        array[0] = 1;
        array[1] = 2;
        array[2] = 2;
        int i = 2, j = 2;
        byte value = 1;
        for (;;) {
            if (j + 1 >= n) {
                break;
            }
            array[++j] = value;
            count += value & 1;
            if ((array[i] & 1) == 0 /* array[i] == 2 */) {
                if (j + 1 >= n) {
                    break;
                }
                array[++j] = value;
                count += value & 1;
            }
            i++;
            value = (byte) (3 ^ value); // 3 ^ 1 = 2, 3 ^ 2 == 1
        }
        return  count;
    }
}
