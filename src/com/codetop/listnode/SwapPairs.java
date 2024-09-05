package com.codetop.listnode;


import com.model.ListNode;

/**
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 */
public class SwapPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);

        ListNode cur = dummy;
        while (head != null && head.next != null) {
            ListNode node1 = head.next;
            ListNode node2 = head.next.next;
            //链表指针反向
            cur.next = node1;
            node1.next = head;
            head.next = node2;
            //更新head和cur
            head = node2;
            cur = cur.next.next;
        }
        return dummy.next;
    }
}
