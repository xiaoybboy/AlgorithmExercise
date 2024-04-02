package com.codetop.listnode;

import com.model.ListNode;

/**
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 */
public class RotateRight {

    /**
     * 1.首先把链路从尾到头组成一个环
     * 2.找到断开连接的位置
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        if (k == 0) return head;

        ListNode tail = head, newTail = head;
        ListNode newHead;
        int n = 0;
        while (tail.next != null) {
            n++;
            tail = tail.next;
        }
        //从尾部把头部连成一个环
        tail.next = head;
        int moveTime = n - k % n;
        if (moveTime == n) {
            return head;
        }

        // 找到断开环的位置
        for (int i = 0; i < moveTime; i++) {
            newTail = newTail.next;
        }
        newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
}
