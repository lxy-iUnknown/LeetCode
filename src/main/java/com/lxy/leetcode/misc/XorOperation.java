package com.lxy.leetcode.misc;

public class XorOperation {
    public static int xorOperation(int n, int start) {
        var result = start;
        for (var i = 1; i < n; i++) {
            start += 2;
            result ^= start;
        }
        return result;
    }

    /**
     * 设f(start, n) = start ^ (start + 2) ^ (start + 4) ^ ... ^ (start + 2(n - 1))，计算f(start, n)<br>
     * 计算方法：f(start, n) = (s ^ (s + 1) ^ (s + 2) ^ ... ^ (s + (n - 1)) << 1) | e，
     * 其中s = floor(start, 2)，e为最低位。总结规律可知只有当n为奇数且start为奇数时e = 1，
     * 即e = (n & start) & 1<br>
     *
     * @param n     数据大小n
     * @param start 起始值start
     * @return 计算结果
     * @see RangeBitwiseOperations#bitwiseXor(int, int)
     */
    public static int xorOperationOptimized(int n, int start) {
        var s = start >> 1;
        return ((RangeBitwiseOperations.bitwiseXor(s, s + n - 1)) << 1) | ((n & start) & 1);
    }
}
