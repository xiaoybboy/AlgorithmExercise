package com.codetop.listnode;

import com.model.ListNode;

/**
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 */
public class KthToLast {

    public int kthToLast(ListNode head, int k) {
        ListNode fast = head;
        //注意fast是从head开始的，所以是k-1
        for (int i = 0; i < k - 1; i++) {
            fast = fast.next;
        }
        //快慢指针
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.val;
    }
}
