package com.lxy.leetcode.linkedlist;

import java.util.ArrayList;

/**
 * <a href="https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/">从尾到头打印链表</a>
 */
public class ReversePrint {

    public static int[] reversePrint(ListNode head) {
        var stack = new ArrayList<Integer>();
        while (head != null) {
            stack.add(head.val);
            head = head.next;
        }
        var length = stack.size();
        var result = new int[length];
        for (var i = 0; i < length; i++) {
            result[i] = stack.get(length - i - 1);
        }
        return result;
    }
}
