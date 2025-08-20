package com.lxy.leetcode.misc;

/**
 * <a href="https://leetcode.cn/problems/bitwise-and-of-numbers-range/">数字范围按位与</a><br>
 * <a href="https://leetcode.cn/problems/xor-operation-in-an-array/">数组异或操作</a>
 */
public class RangeBitwiseOperations {
    private static void rangeCheck(int left, int right) {
        if (left > right) {
            throw new IllegalArgumentException("left(" + left + ") > right(" + right + ")");
        }
        if (left < 0) {
            throw new IllegalArgumentException("left(" + left + ") < 0");
        }
    }

    /**
     * 设xorSum(x) = 0 ^ 1 ^ 2 ^ ... ^ (n - 1) ^ n，计算xorSum(n)
     * 计算方法：<br>
     * 首先有一个结论：对于任意的整数i，有4i ^ (4i + 1) ^ (4i + 2) ^ (4i + 3) = 0<br>
     * 证明：4i、4i + 1、4i + 2、4i + 3的最低两位分别为00、01、10、11，其他位相同。
     * 其他位异或结果为0（两两一组异或结果为0，0和0异或结果也为0），
     * 最低两位异或结果为00 ^ 01 ^ 10 ^ 11 = 0，故所有位异或结果均为0<br>
     * 由该结论可知，xorSum(x)可以从0开始消去若干个四位一组的数字，由此可知：
     * 当n = 4k时还剩x，当n = 4k + 1时还剩x和x - 1，当n = 4k + 2时还剩x、x - 1和x - 2，当x = 4k + 3
     * 时所有数字全部消去，即：xorSum(x) = 4k => x, 4k + 1 => x ^ (x - 1),
     * 4k + 2 => x ^ (x - 1) ^ (x - 2), 4k + 3 =>  0<br>
     * 进一步化简：x ^ (x - 1) = xxxxxx_01 ^ xxxxxx_00 = 000000_01 = 1，
     * x ^ (x - 1) ^ (x - 2) = xxxxxx_10 ^ xxxxxx_01 ^ xxxxxx_00 = xxxxxx_11
     * = xxxxxx_10 + 1 = x + 1（其中xxxxxx为未知的高位部分）<br>
     * 即xorSum(x) = 4k => x, 4k + 1 => 1, 4k + 2 => x + 1, 4k + 3 => 0
     *
     * @param n 输入参数n
     * @return 计算结果
     */
    private static int xorSum(int n) {
        return switch (n % 4) {
            case 0 -> n;
            case 1 -> 1;
            case 2 -> n + 1;
            default -> 0;
        };
    }

    /**
     * 设f(left, right) = left & (left + 1) & (left + 2) & ... & right，计算f(left, right)<br>
     * 计算方法：加法运算只影响较低位，因此left、left + 1、left + 2...right可能会有公共前缀。
     * 非公共部分按位与总是0（这些数的非公共部分中每一位都至少会有一个0），因此结果除了公共前缀外其余部分均为0。
     *
     * @param left  起始值
     * @param right 终止值
     * @return 计算结果
     */
    public static int bitwiseAnd(int left, int right) {
        rangeCheck(left, right);
        var shift = 0;
        // 寻找公共前缀
        while (left != right) {
            left >>>= 1;
            right >>>= 1;
            // 记录移动的位数
            shift++;
        }
        return left << shift;
    }

    /**
     * 设f(left, right) = left & (left + 1) & (left + 2) & ... & right，计算f(left, right)<br>
     * 计算方法：思想和{@link RangeBitwiseOperations#bitwiseAnd(int, int)}相同，只不过通过x & (x - 1)
     * 消去最低位的1。循环终止条件是非公共部分均为0，此时m &ge; n，于是循环条件为m < n。
     *
     * @param left  起始值
     * @param right 终止值
     * @return 计算结果
     */
    public static int bitwiseAndBrianKernighan(int left, int right) {
        rangeCheck(left, right);
        while (left < right) {
            right &= (right - 1);
        }
        return right;
    }

    /**
     * Returns floor(log<sub>2</sub>(value)). When input value is 0, 0 is returned
     *
     * @param value The value.
     * @return floor(log<sub>2</sub>(value))
     */
    private static int log2(int value) {
        // The 0 -> 0 contract is fulfilled by setting the LSB to 1.
        // Log(1) is 0, and setting the LSB for values > 1 does not change the log2 result.
        return 31 ^ Integer.numberOfLeadingZeros(value | 1);
    }

    /**
     * 设f(left, right) = left & (left + 1) & (left + 2) & ... & right，计算f(left, right)<br>
     * 计算方法：思想和{@link RangeBitwiseOperations#bitwiseAnd(int, int)}相同。<br>
     * 2222222010011 —— left<br>
     * 2222222101101 —— right<br>
     * 0000000133333 —— left ^ right<br>
     * 设x = floor(log<sub>2</sub>(left ^ right))，则x为非公共部分
     * （除去非公共部分最高位）的二进制位数<br>
     * 0000000100000 —— 1 << x<br>
     * 1111111100000 —— -(1 << x)<br>
     * 2222222000000 —— -(1 << x) & left<br>
     * 注：由于left &le; right，因此left的非公共部分最高位一定为0，而right的非公共部分最高位一定为1。
     * "2"和"3"代表任意比特位
     *
     * @param left  起始值
     * @param right 终止值
     * @return 计算结果
     */
    public static int bitwiseAndOptimized(int left, int right) {
        rangeCheck(left, right);
        return -(1 << log2(left ^ right)) & left;
    }

    /**
     * 设f(left, right) = left ^ (left + 1) ^ (left + 2) ^ ... ^ right，计算f(left, right)<br>
     * 计算方法：f(left, right) = (0 ^ 1 ^ ... ^ (left - 1)) ^
     * (0 ^ 1 ^ ... ^ (left - 1) ^ left ^ (left + 1) ^ ... ^ right
     *
     * @param left  起始值
     * @param right 终止值
     * @return 计算结果
     */
    public static int bitwiseXor(int left, int right) {
        rangeCheck(left, right);
        return xorSum(left - 1) ^ xorSum(right);
    }
}
