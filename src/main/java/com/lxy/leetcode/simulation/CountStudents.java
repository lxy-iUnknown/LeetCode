package com.lxy.leetcode.simulation;

public class CountStudents {
    private static boolean canContinue(int[] students, int[] sandwiches,
                                       int queueHead, int stackTop) {

        int sandwich = sandwiches[stackTop];
        for (int i = queueHead; i < students.length; i++) {
            if ((students[i] ^ sandwich) == 0) {
                return true;
            }
        }
        return false;
    }

    public static int countStudents(int[] students, int[] sandwiches) {
        int length = students.length;
        int stackTop = 0, queueHead = 0;
        while (stackTop < length && canContinue(students, sandwiches, queueHead, stackTop)) {
            int student = students[queueHead];
            int sandwich = sandwiches[stackTop];
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
        int s0 = 0, s1 = 0;
        for (int student : students) {
            if (student == 0) {
                s0++;
            } else {
                s1++;
            }
        }
        for (int sandwich : sandwiches) {
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
