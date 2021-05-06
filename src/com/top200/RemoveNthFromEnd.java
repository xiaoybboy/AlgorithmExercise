package com.top200;


import com.model.ListNode;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点并返回链表的头指针
 * 例如，
 * 给出的链表为: 1\to 2\to 3\to 4\to 51→2→3→4→5, n= 2  n=2.
 * 删除了链表的倒数第 nn 个节点之后,链表变为1\to 2\to 3\to 51→2→3→5.
 * <p>
 * 备注：
 * 题目保证 nn 一定是有效的
 * 请给出请给出时间复杂度为\ O(O(n) 的算法
 * <p>
 * 首先，我们要清楚链表的长度length，这样的话，要删除倒数第n个节点的话，就是删除正序的第（length - n）个节点（从 0 开始遍历链表）
 * （当删除倒数第length的节点时例外，因为我们遍历链表的时候从 0 开始，所以这个时候我们需要单独将条件提出）。
 * 其次，当我们遍历到了要删除的节点的前一位的时候，我们只需要让其的 next 指向其 next.next，这样的话就可以删除该节点。
 * 最后，当我们遍历链表的时候，需要有一个指针指向该链表的首部，这样就不会丢失链表遍历位置之前的元素。
 */
public class RemoveNthFromEnd {

    /**
     * @param head ListNode类
     * @param n    int整型
     * @return ListNode类
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //计算链表的长度
        ListNode node = head;
        //构造结果
        ListNode result = head;
        //结果的头部指针
        ListNode begin = result;

        //1.首先计算链表的总长度
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }

        //2.正序中要删除的位置
        int location = length - n;
        if (location == 0) {
            result = result.next;
            return result;
        }

        //前面location-1个节点跳过
        for (int i = 0; i < location - 1; i++) {
            result = result.next;
        }
        //删除第n个节点
        result.next = result.next.next;
        return begin;
    }
}
