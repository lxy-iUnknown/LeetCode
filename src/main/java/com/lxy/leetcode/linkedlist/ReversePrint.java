package com.lxy.leetcode.linkedlist;

import java.util.ArrayList;

/**
 * <a href="https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof">从尾到头打印链表</a>
 */
public class ReversePrint {

    public static int[] reversePrint(ListNode head) {
        ArrayList<Integer> stack = new ArrayList<>();
        while (head != null) {
            stack.add(head.val);
            head = head.next;
        }
        int length = stack.size();
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = stack.get(length - i - 1);
        }
        return result;
    }
}
