package com.sword.offer;

import com.model.ListNode;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * <p>
 * 在链表中：倒数的+顺数的长度等于链表总长度，所以可以设置两个指针，
 * 一个先走K步，剩下的到链表的末尾要走的步数就是倒数第k个节点，需要从头开始走的步数
 */
public class FindKthToTail {

    /**
     * 输出该链表中倒数第k个结点
     * @param pHead
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode pHead, int k) {
        ListNode first = pHead;
        ListNode second = pHead;
        for (int i = 0; i < k; i++) {
            if (first == null){
                return first;
            }
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }
        return second;
    }
}
