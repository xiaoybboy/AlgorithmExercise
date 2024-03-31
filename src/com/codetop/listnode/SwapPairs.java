package com.codetop.listnode;


import com.model.ListNode;

/**
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 */
public class SwapPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);

        head = dummy;
        while (head.next != null && head.next.next != null) {
            ListNode node1 = head.next;
            ListNode node2 = head.next.next;

            head.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            head = node1;
        }
        return dummy.next;
    }
}
