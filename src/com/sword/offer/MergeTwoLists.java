package com.sword.offer;

import com.model.ListNode;

/**
 * 将两个有序的链表合并为一个新链表，要求新的链表是通过拼接两个链表的节点来生成的，且合并后新链表依然有序。
 */
public class MergeTwoLists {

    /**
     * @param l1 链表1
     * @param l2 链表2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1) {
            return l2;
        }
        if (null == l2) {
            return l1;
        }
        //合并后的链表
        ListNode mergeNode = new ListNode(0);
        //指针
        ListNode currentNode = mergeNode;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                currentNode.next = l1;
                currentNode = currentNode.next;
                l1 = l1.next;
            } else {
                currentNode.next = l2;
                currentNode = currentNode.next;
                l2 = l2.next;
            }
        }

        //如果循环完，l1还不为空
        if (l1 != null) {
            currentNode.next = l1;
        }

        if (l2 != null) {
            currentNode.next = l2;
        }
        return mergeNode.next;
    }
}
