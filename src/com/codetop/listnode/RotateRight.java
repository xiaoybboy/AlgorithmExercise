package com.codetop.listnode;

import com.model.ListNode;

/**
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 */
public class RotateRight {

    /**
     * 1.首先把链路从尾到头组成一个环
     * 2.找到断开连接的位置
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        if (k == 0) return head;
        //1.找到链表尾部并计算链表长度
        ListNode tail = head;
        int n = 1;
        while (tail.next != null) {
            n++;
            tail = tail.next;
        }
        //尾部向后移动k位，就是原头部向后移动n-k%n位
        //比如123456，k=2，新的尾节点是4,从1移动到4，移动6-2%6次
        int move = n - k % n;
        if (move == n) {
            return head;
        }
        //从尾部把头部连成一个环
        tail.next = head;
        //寻找尾节点
        while (move > 0) {
            tail = tail.next;
            move--;
        }
        ListNode newHead = tail.next;
        tail.next = null;
        return newHead;
    }
}
