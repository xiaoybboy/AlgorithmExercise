package com.codetop.listnode;

import com.model.ListNode;

/**
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 */
public class SortList {

    /**
     * 分割 cut 环节： 找到当前链表 中点，并从 中点 将链表断开（以便在下次递归 cut 时，链表片段拥有正确边界）；
     * 我们使用 fast,slow 快慢双指针法，奇数个节点找到中点，偶数个节点找到中心左边的节点。
     * 找到中点 slow 后，执行 slow.next = None 将链表切断。
     * <p>
     * 递归分割时，输入当前链表左端点 head 和中心节点 slow 的下一个节点 tmp(因为链表是从 slow 切断的)。
     * cut 递归终止条件： 当 head.next == None 时，说明只有一个节点了，直接返回此节点。
     * <p>
     * 合并 merge 环节： 将两个排序链表合并，转化为一个排序链表。
     * 双指针法合并，建立辅助 ListNode h 作为头部。
     * 设置两指针 left, right 分别指向两链表头部，比较两指针处节点值大小，由小到大加入合并链表头部，指针交替前进，直至添加完两个链表。
     * 返回辅助ListNode h 作为头部的下个节点 h.next。
     * 时间复杂度 O(l + r)，l, r 分别代表两个链表长度。
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head, pre = head;
        //寻找中间节点
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //断开链表
        pre.next = null;
        return merge(sortList(head), sortList(slow));//不断利用快慢指针找到切割点
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
