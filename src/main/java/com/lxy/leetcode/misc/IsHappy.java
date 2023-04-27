package com.lxy.leetcode.misc;

import com.lxy.leetcode.linkedlist.LinkedListUtil;
import com.lxy.leetcode.linkedlist.ListNode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * <a href="https://leetcode.cn/problems/happy-number">快乐数</a>
 */
public class IsHappy {
    // Sorted cycle members: 4, 16, 37, 58, 89, 145, 42, 20
    private static final int[] SORTED_CYCLE_MEMBERS = new int[]{
            4, 16, 20, 37, 42, 58, 89, 145
    };

    private static int squareDigitSum(int n) {
        int sum = 0;
        while (n > 0) {
            int temp = n / 10;
            int digit = n - temp * 10;
            sum += digit * digit;
            n = temp;
        }
        return sum;
    }

    public static boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        for (;;) {
            if (n == 1) {
                return true;
            }
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
            n = squareDigitSum(n);
        }
    }

    /**
     * 判断一个数是否为快乐数<br>
     * 事实上，反复迭代的过程可视为一个隐式链表，因此要想判断是否为快乐数，只需判断链表是否有环，
     * 可使用快慢指针法（参见{@link LinkedListUtil#hasCycle(ListNode)}）
     * @param n 数字n
     * @return 是否为快乐数
     */
    public static boolean isHappyLinkedList(int n) {
        int slow = n, fast = n;
        // 检查快指针是否能继续走动
        while (fast != 1 && (fast = squareDigitSum(fast)) != 1) {
            slow = squareDigitSum(slow);
            fast = squareDigitSum(fast);
            // 快慢指针相遇
            if (slow == fast) {
                return false;
            }
        }
        // 没有环
        return true;
    }

    public static boolean isHappyMath(int n) {
        while (n != 1 && Arrays.binarySearch(SORTED_CYCLE_MEMBERS, n) < 0) {
            n = squareDigitSum(n);
        }
        return n == 1;
    }
}
