package com.sword.offer;

import com.model.ListNode;

/**
 * 对于一个给定的链表，返回环的入口节点，如果没有环，返回null
 * 拓展：
 * 你能给出不利用额外空间的解法么？
 * <p>
 * 思路：快慢指针法
 * <p>
 * 第一步，找环中相汇点。分别用p1，p2指向链表头部，
 * p1每次走一步，p2每次走二步，直到p1==p2找到在环中的相汇点。
 * <p>
 * 那么我们可以知道fast指针走过a+b+c+b
 * slow指针走过a+b
 * 那么2*(a+b) = a+b+c+b
 * 所以a = c
 * <p>
 * 那么此时让fast回到起点，slow依然停在z，两个同时开始走，一次走一步
 */
public class DetectListNodeCycleStartNode {

    /**
     * 寻找链表中环的入口节点
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                //fast 放在起点
                fast = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
