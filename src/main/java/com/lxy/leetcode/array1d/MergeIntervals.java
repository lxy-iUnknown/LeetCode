package com.lxy.leetcode.array1d;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.cn/problems/merge-intervals/">合并区间</a>
 */
public class MergeIntervals {
    private static final int START = 0;
    private static final int END = 1;

    /**
     * Try to merge two intervals [s1, e1] and [s2, e2], assuming s2 >= s1
     *
     * @param interval1 First interval
     * @param interval2 Second interval
     * @return Merged interval(null if merge failed)
     */
    private static int[] tryMerge(int[] interval1, int[] interval2) {
        // Case 1/2:             Case 3:                 Case 4:
        //   ---------------           ---------
        //   |             |           |       |
        //   ---------     |       ---------   |      -----   -----
        //   |       |     |       |   |   |   |      |   |   |   |
        // ------------------->  --------------->  ------------------>
        //  s1,s2  e1/e2  e2/e1   s1  s2  e2  e1     s1  e1  s2  e2
        int end1 = interval1[END];
        if (interval2[START] <= end1) {
            return new int[]{interval1[START], Math.max(end1, interval2[END])};
        }
        return null;
    }

    private static void moveForward(int[][] intervals, int startIndex, int length) {
        for (int i = startIndex + 1; i < length; i++) {
            intervals[i - 1] = intervals[i];
        }
    }

    public static int[][] merge(int[][] intervals) {
        int length = intervals.length;
        if (length == 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[START]));
        int i = 0;
        while (i < length - 1) {
            int[] merged = tryMerge(intervals[i], intervals[i + 1]);
            if (merged == null) {
                i++;
            } else {
                intervals[i] = merged;
                moveForward(intervals, i + 1, length);
                length--;
            }
        }
        return Arrays.copyOf(intervals, length);
    }

    public static int[][] mergeOptimized(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval1 -> interval1[START]));
        int count = 0;
        ArrayList<int[]> merged = new ArrayList<>(32);
        merged.add(intervals[0]);
        for (int[] interval : intervals) {
            int[] result = tryMerge(merged.get(count), interval);
            if (result == null) {
                merged.add(interval);
                count++;
            } else {
                merged.set(count, result);
            }
        }
        return merged.toArray(int[][]::new);
    }
}
