package com.codetop.listnode;

import com.model.ListNode;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeK(lists, 0, lists.length - 1);
    }

    /**
     * 归并
     *
     * @param listNodes
     * @param left
     * @param right
     * @return
     */
    private ListNode mergeK(ListNode[] listNodes, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            ListNode listNode1 = mergeK(listNodes, left, mid);
            ListNode listNode2 = mergeK(listNodes, mid + 1, right);
            return mergeTwoLists(listNode1, listNode2);
        } else if (left == right) {
            return listNodes[left];
        }
        return null;
    }

    /**
     * 合并两个有序链表
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 != null) {
            cur.next = list1;
        }
        if (list2 != null) {
            cur.next = list2;
        }
        return dummy.next;
    }
}
