package com.lxy.leetcode.util;

public class CycleDetector {
    /**
     * 使用快慢指针法检测链表是否有环，如果有环则返回快慢指针相遇的节点，否则返回null<br>
     * 快慢指针刚开始都位于链表头部，快指针走两步，慢指针走一步，
     * 如果无法走动（指针为空）则说明没有环，如果快慢指针相遇则说明有环
     *
     * @param head 链表表头
     * @return 如果链表有环则返回快慢指针相遇位置，否则返回null
     */
    public static <TNode extends ILinkedNode<TNode>> TNode detect(TNode head) {
        if (head.isNull()) {
            return null;
        }
        var slow = head;
        var fast = head;
        // 检查快指针是否能继续走动
        while (!fast.isNull() && !(fast = fast.next()).isNull()) {
            slow = slow.next();
            fast = fast.next();
            // 快慢指针相遇
            if (slow.equals(fast)) {
                return slow;
            }
        }
        // 没有环
        return null;
    }
}
