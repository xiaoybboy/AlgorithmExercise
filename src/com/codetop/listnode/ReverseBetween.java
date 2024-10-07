package com.codetop.listnode;

import com.model.ListNode;

/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 */
public class ReverseBetween {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        //到达left之前的一个节点
        ListNode prev = dummy;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        //反转left到right链表节点
        ListNode cur = prev.next;//反转的第一个节点
        for (int i = left; i < right; i++) {
            //每两个一对，开始翻转
            ListNode next = cur.next;
            ListNode nextNext = next.next;
            //123->213
            cur.next = nextNext;
            next.next = prev.next;
            prev.next = next;

        }
        return dummy.next;
    }
}
