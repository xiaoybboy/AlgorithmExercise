package com.codetop.listnode;

import com.model.ListNode;

public class MiddleNode {

    /**
     * 链表的中间节点
     * 快慢指针
     *
     * @param head
     * @return
     */
    private ListNode middleNode(ListNode head) {
        // 快慢指针初始化指向 head
        ListNode slow = head, fast = head;
        // 快指针走到末尾时停止
        while (fast != null && fast.next != null) {
            // 慢指针走一步，快指针走两步
            slow = slow.next;
            fast = fast.next.next;
        }
        // 慢指针指向中点
        return slow;
    }
}
