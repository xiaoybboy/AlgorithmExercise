package com.sword.offer;

import com.model.ListNode;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * <p>
 * 初始化：定义cur指向新链表的头结点
 * 操作：
 * <p>
 * 如果l1指向的结点值小于等于l2指向的结点值，则将l1指向的结点值链接到cur的next指针，然后l1指向下一个结点值
 * 否则，让l2指向下一个结点值
 * 循环步骤1,2，直到l1或者l2为null
 * 将l1或者l2剩下的部分链接到cur的后面
 */
public class MergeListNode {

    /**
     * 合并两个链表
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode h = new ListNode(-1);
        ListNode cur = h;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 != null) cur.next = list1;
        if (list2 != null) cur.next = list2;
        return h.next;
    }
}
