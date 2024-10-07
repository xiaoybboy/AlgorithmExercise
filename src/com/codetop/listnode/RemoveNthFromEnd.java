package com.codetop.listnode;

import com.model.ListNode;

/**
 * 返回链表的导数第K个节点
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 虚拟头结点
        ListNode dummy = new ListNode(-1, head);
        // 删除倒数第 n 个，要先找倒数第 n + 1 个节点
        ListNode x = findFromEnd(dummy, n + 1);
        // 删掉倒数第 n 个节点
        x.next = x.next.next;
        return dummy.next;
    }

    /**
     * 双指针法
     */
    // 返回链表的倒数第 k 个节点
    private ListNode findFromEnd(ListNode head, int k) {
        ListNode fast = head;
        // fast 先走 k 步
        while (fast != null && k > 0) {
            fast = fast.next;
            k--;
        }
        ListNode slow = head;
        // fast 和 slow 同时走 n - k 步
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // slow 现在指向第 n - k + 1 个节点，即倒数第 k 个节点
        return slow;
    }
}
