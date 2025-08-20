package com.lxy.leetcode.simulation;

/**
 * <a href="https://leetcode.cn/problems/execution-of-all-suffix-instructions-staying-in-a-grid/">执行所有后缀指令</a>
 */
public class ExecuteInstructions {
    private static final int X = 0;
    private static final int Y = 1;

    public static int[] executeInstructions(int n, int[] startPos, String s) {
        var operations = s.toCharArray();
        var length = operations.length;
        var result = new int[length];
        for (var i = 0; i < length; i++) {
            var x = startPos[X];
            var y = startPos[Y];
            int j;
            for (j = i; j < length; j++) {
                switch (operations[j]) {
                    case 'L' -> y--;
                    case 'R' -> y++;
                    case 'U' -> x--;
                    case 'D' -> x++;
                }
                if (x < 0 || x >= n || y < 0 || y >= n) {
                    break;
                }
            }
            result[i] = j - i;
        }
        return result;
    }
}
