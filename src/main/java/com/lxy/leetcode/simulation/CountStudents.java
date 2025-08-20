package com.lxy.leetcode.simulation;

/**
 * <a href="https://leetcode.cn/problems/number-of-students-unable-to-eat-lunch/">无法吃午餐的学生数量</a>
 */
public class CountStudents {
    private static boolean canContinue(int[] students, int[] sandwiches,
                                       int queueHead, int stackTop) {

        var sandwich = sandwiches[stackTop];
        for (var i = queueHead; i < students.length; i++) {
            if ((students[i] ^ sandwich) == 0) {
                return true;
            }
        }
        return false;
    }

    public static int countStudents(int[] students, int[] sandwiches) {
        var length = students.length;
        var stackTop = 0;
        var queueHead = 0;
        while (stackTop < length && canContinue(students, sandwiches, queueHead, stackTop)) {
            var student = students[queueHead];
            var sandwich = sandwiches[stackTop];
            if ((student ^ sandwich) == 0) {
                // Pop stack
                stackTop++;
                // Dequeue
                queueHead++;
            } else {
                // Dequeue then enqueue
                System.arraycopy(students, queueHead + 1,
                        students, queueHead, length - queueHead - 1);
                students[length - 1] = student;
            }
        }
        return length - queueHead;
    }

    public static int countStudentsOptimized(int[] students, int[] sandwiches) {
        var s0 = 0;
        var s1 = 0;
        for (var student : students) {
            if (student == 0) {
                s0++;
            } else {
                s1++;
            }
        }
        for (var sandwich : sandwiches) {
            if (sandwich == 0 && s0 != 0) {
                s0--;
            } else if (sandwich == 1 && s1 != 0) {
                s1--;
            } else {
                break;
            }
        }
        return s1 + s0;
    }
}
