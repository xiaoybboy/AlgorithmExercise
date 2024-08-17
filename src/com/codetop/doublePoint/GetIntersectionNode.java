package com.codetop.doublePoint;

import com.model.ListNode;

/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * <p>
 * 图示两个链表在节点 c1 开始相交：
 */
public class GetIntersectionNode {

    /**
     * 双指针
     * 设「第一个公共节点」为 node ，「链表 headA」的节点数量为 a ，「链表 headB」的节点数量为 b ，「两链表的公共尾部」的节点数量为 c ，则有：
     * <p>
     * 头节点 headA 到 node 前，共有 a−c 个节点；
     * 头节点 headB 到 node 前，共有 b−c 个节点；
     * <p>
     * 考虑构建两个节点指针, B 分别指向两链表头节点 headA , headB ，做如下操作：
     * <p>
     * 指针 A 先遍历完链表 headA ，再开始遍历链表 headB ，当走到 node 时，共走步数为：
     * a+(b−c)
     * 指针 B 先遍历完链表 headB ，再开始遍历链表 headA ，当走到 node 时，共走步数为：
     * b+(a−c)
     * 如下式所示，此时指针 A , B 重合，并有两种情况：
     * <p>
     * 因为有a+(b−c)=b+(a−c)
     * 若两链表 有 公共尾部 (即 c>0 ) ：指针 A , B 同时指向「第一个公共节点」node 。
     * 若两链表 无 公共尾部 (即 c=0 ) ：指针 A , B 同时指向 nullnullnull
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (A != B) {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;
    }
}
