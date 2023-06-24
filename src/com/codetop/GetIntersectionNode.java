package com.codetop;

import com.model.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * <p>
 * 图示两个链表在节点 c1 开始相交：
 */
public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode node = headA;
        while (node != null) {
            set.add(node);
            node = node.next;
        }

        node = headB;
        while (node != null) {
            if (set.contains(node)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    /**
     * 方法二：双指针
     * 思路和算法
     * <p>
     * 使用双指针的方法，可以将空间复杂度降至 O(1)
     * <p>
     * 只有当链表 headA和 headB 都不为空时，两个链表才可能相交。因此首先判断链表 headA 和 headB 是否为空，如果其中至少有一个链表为空，则两个链表一定不相交，返回 null;
     * <p>
     * 当链表 headA 和 headB 都不为空时，创建两个指针 pA 和 pB，初始时分别指向两个链表的头节点 headA 和 headB，然后将两个指针依次遍历两个链表的每个节点。具体做法如下：
     * <p>
     * 每步操作需要同时更新指针 pA 和 pB。
     * <p>
     * 如果指针 pA 不为空，则将指针 pA 移到下一个节点；如果指针 pB 不为空，则将指针 pB 移到下一个节点。
     * <p>
     * 如果指针 pA 为空，则将指针 pA 移到链表 headB 的头节点；如果指针 pB 为空，则将指针 pB 移到链表 headA 的头节点。
     * <p>
     * 当指针 pA 和 pB 指向同一个节点或者都为空时，返回它们指向的节点或者 null。
     * <p>
     * 证明
     * <p>
     * 下面提供双指针方法的正确性证明。考虑两种情况，第一种情况是两个链表相交，第二种情况是两个链表不相交。
     * <p>
     * 情况一：两个链表相交
     * <p>
     * 链表 headA 和 headB 的长度分别是 mmm 和 nnn。假设链表 headA 的不相交部分有 aaa 个节点，链表 headB 的不相交部分有 bbb 个节点，两个链表相交的部分有 ccc 个节点，则有 a+c=ma+c=ma+c=m，b+c=nb+c=nb+c=n。
     * <p>
     * 如果 a=ba=ba=b，则两个指针会同时到达两个链表相交的节点，此时返回相交的节点；
     * <p>
     * 如果 a≠ba
     * 
     * =b，则指针 pA 会遍历完链表 headA，指针 pB 会遍历完链表 headB，两个指针不会同时到达链表的尾节点，然后指针 pA 移到链表 headB 的头节点，指针 pB 移到链表 headA 的头节点，然后两个指针继续移动，在指针 pA 移动了 a+c+ba+c+ba+c+b 次、指针 pB 移动了 b+c+ab+c+ab+c+a 次之后，两个指针会同时到达两个链表相交的节点，该节点也是两个指针第一次同时指向的节点，此时返回相交的节点。
     * <p>
     * 情况二：两个链表不相交
     * <p>
     * 链表 headA 和 headB 的长度分别是 mmm 和 nnn。考虑当 m=nm=nm=n 和 m≠nm \ne nm
     * 
     * =n 时，两个指针分别会如何移动：
     * <p>
     * 如果 m=nm=nm=n，则两个指针会同时到达两个链表的尾节点，然后同时变成空值 null，此时返回 null；
     * <p>
     * 如果 m≠nm \ne nm
     * 
     * =n，则由于两个链表没有公共节点，两个指针也不会同时到达两个链表的尾节点，因此两个指针都会遍历完两个链表，在指针 pA 移动了 m+nm+nm+n 次、指针 pB 移动了 n+mn+mn+m 次之后，两个指针会同时变成空值 null，此时返回 null。
     *
     * @param headA
     * @param headB
     * @return
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
