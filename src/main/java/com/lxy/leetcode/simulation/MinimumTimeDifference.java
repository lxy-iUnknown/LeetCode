package com.lxy.leetcode.simulation;

import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/minimum-time-difference/">最小时间差</a>
 */
public class MinimumTimeDifference {

    private static final int RADIX = 10;
    private static final int MINUTES_PER_HOUR = 60;
    private static final int HOURS_PER_DAY = 24;
    private static final int COUNT = HOURS_PER_DAY * MINUTES_PER_HOUR;

    // Use modulus to loop back
    private static int normalize(int value) {
        return Math.floorMod(value, COUNT);
    }

    private static int timePointValue(String timePoint) {
        // 手动内联展开后的代码
        return timePoint.charAt(0) * (RADIX * MINUTES_PER_HOUR) +
                timePoint.charAt(1) * MINUTES_PER_HOUR +
                timePoint.charAt(3) * RADIX + timePoint.charAt(4) -
                '0' * (RADIX + 1) * (MINUTES_PER_HOUR + 1);
    }

    private static int nextOne(boolean[] array, int i) {
        while (i < COUNT && !array[i]) {
            i = normalize(i + 1);
        }
        return i;
    }

    public static int findMinDifference(List<String> timePoints) {
        boolean[] timePointValues = new boolean[COUNT];
        for (String timePoint : timePoints) {
            int index = timePointValue(timePoint);
            if (timePointValues[index]) {
                // Duplicate time point exists
                return 0;
            }
            timePointValues[index] = true;
        }
        // Here we can ensure that there are at least two different time points
        int min = COUNT + 1; // Infinity
        int first = nextOne(timePointValues, 0);
        int start = first, end;
        do {
            end = nextOne(timePointValues, normalize(start + 1));
            int delta = normalize(end - start);
            if (delta < min) {
                min = delta;
            }
            start = end;
        } while (end != first);
        return min;
    }
}
