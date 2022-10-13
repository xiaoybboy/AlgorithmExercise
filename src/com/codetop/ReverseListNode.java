package com.codetop;

import com.model.ListNode;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
public class ReverseListNode {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
           ListNode next = cur.next;
           cur.next = pre;
           pre = cur;
           cur = next;
        }
        return pre;
    }
}
