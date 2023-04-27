package com.lxy.leetcode.misc;

import com.lxy.leetcode.util.Constants;

/**
 * <a href="https://leetcode.cn/problems/jian-sheng-zi-lcof/">剪绳子</a>
 */
public class CuttingRope {

    // 快速幂取模
    private static long powerMod3(long n) {
        long sum = 1;
        long a = 3;
        while (n > 0) {
            if ((n & 1) != 0) {
                sum = (sum * a) % Constants.MODULO;
            }
            a = (a * a) % Constants.MODULO;
            n >>= 1;
        }
        return sum;
    }

    /**
     * 将长度为n的绳子分成m段(n > 1, m > 1)，求各段长度乘积的最大值<br>
     * 结论一：当各段长度相等时长度最大<br>
     * 证明：设各段长度分别为n<sub>1</sub>，n<sub>2</sub>...n<sub>m</sub>，则
     * n / m = (n<sub>1</sub> + n<sub>2</sub> + ... + n<sub>m</sub>) / m &ge;
     * root(n<sub>1</sub>n<sub>2</sub>...n<sub>m</sub>, m)，当且仅当
     * n<sub>1</sub> = n<sub>1</sub> = ... = n<sub>m</sub>时等号成立。<br>
     * 结论二：各段长度应尽可能为3<br>
     * 证明：设绳子按照长度为x均匀分段，则各段乘积f(x) = x<sup>n / x</sup>
     * （此时可忽略n和x均为整数的限制条件），求导得f'(x) = nx<sup>n / x - 2</sup>(1 - lnx)，当x <
     * e时f(x)单调递增，当x &ge; e时f(x)单调递减，当x = e时f(x)取得最大值。<br>
     * 又因为x为整数，所以只需比较f(2)和f(3)的大小，f(2) / f(3) = ((n / 2) * ln2) / ((n / 3) ln3)
     * = 3ln2 / 2ln3 = ln8 / ln9 < 1，因此f(3) > f(2)。因此当x = 3时f(x)取最大值<br>
     * 又因为n不一定能被3整除，因此需要对余数单独讨论。设n / 3 = a...b，则：<br>
     * 当b = 0时，n恰可被3整除，因此各段长度乘积的最大值为3<sup>a</sup><br>
     * 当b = 1时，最后长度为1的段有两种分法，一种是单独分为一段，另一种是和某一长度为3的段接成长度为4的段，
     * 这两种分法所得各段长度乘积最大值之比为3<sup>a</sup> / (3<sup>a - 1</sup> * 4) = 3 / 4 < 1，
     * 因此第二种分法各段长度乘积较大。<br>
     * 当b = 2时，最后长度为1的段有三种分法，第一是单独分为一段，第二是和某一长度为3的段接成长度为5的段，
     * 第三是拆成两段长度为1的段，然后把这两段分别和长度为3的段接成长度为4的段。
     * 分法二和分法三所得各段长度乘积很容易比较，即比较(3 + 0) * (3 + 2)和(3 + 1) * (3 + 1)的大小，
     * 显然后者较大。而分法一和分法三所得各段长度乘积最大值之比为(3<sup>a</sup> * 2) /
     * (3<sup>a - 2</sup> * 16) = (9 * 2) / 16 = 18 / 16 > 1，因此第一种分法各段长度乘积较大。<br>
     * 综上所述，设n / 3 = a...b，则：<br>
     * 当b = 0时，结果为3<sup>a</sup><br>
     * 当b = 1时，结果为3<sup>a - 1</sup> * 4<br>
     * 当b = 2时，结果为3<sup>a</sup> * 2<br>
     * 注：root(x, n)为x开n次根，即x<sup>1 / n</sup>
     * @param n 绳子长度n
     * @return 各段长度乘积最大值
     */
    public static int cuttingRope(int n) {
        // Special case
        if (n == 2) {
            return 1; // 1 * 1
        }
        if (n == 3) {
            return 2; // 1 * 2 because m > 1
        }
        int x = n / 3;
        return switch (n - x * 3) {
            case 0 -> (int) (powerMod3(x) % Constants.MODULO);
            case 1 -> (int) ((powerMod3(x - 1) * 4) % Constants.MODULO);
            default -> (int) ((powerMod3(x) * 2) % Constants.MODULO);
        };
    }
}
