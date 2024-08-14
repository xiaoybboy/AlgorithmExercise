package com.codetop.listnode;

import com.model.ListNode;

/**
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * <p>
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 * <p>
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class ReorderList {

    public void reorderList(ListNode head) {
        //1.找到链表中间节点
        ListNode midNode = midListNode(head);
        ListNode list1 = head;
        ListNode list2 = midNode.next;
        //断开左侧链表
        midNode.next = null;
        //2.翻转右侧链表
        list2 = reverse(list2);
        //3.左侧链表和翻转后的右侧链表合并
        mergetTwoListNode(list1, list2);
    }

    //链表中间节点
    private ListNode midListNode(ListNode listNode) {
        ListNode fast = listNode, slow = listNode;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    //翻转链表
    private ListNode reverse(ListNode listNode) {
        ListNode prev = null, cur = listNode;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            //翻转链表指向
            cur.next = prev;
            //改变pre和cur
            prev = cur;
            cur = next;
        }
        return prev;
    }

    //合并2个链表
    private ListNode mergetTwoListNode(ListNode list1, ListNode list2) {
        ListNode temp1 = null, temp2 = null;
        while (list1 != null && list2 != null) {
            //记录list1和list2的后续节点
            temp1 = list1.next;
            temp2 = list2.next;
            //每次循环新增两个节点
            list1.next = list2;
            list1 = temp1;

            list2.next = list1;
            list2 = temp2;
        }
        return list1;
    }
}
