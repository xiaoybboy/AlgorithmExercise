package com.codetop.listnode;

import com.model.ListNode;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
public class ReverseListNode {

    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        ListNode next;
        while (cur != null) {
            next = cur.next;
            //当前节点指向前一个节点
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 判断链表是不是回文
     * 思路：把前半部分链表翻转，然后跟后半部分链表比较
     * 怎么找到前半部分链表：快慢指针法
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            //翻转慢指针部分的链表
            ListNode next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }

        //如果fast!=null，说明链表总结点数是奇数
        if (fast != null) {
            slow = slow.next;
        }
        //开始比较前半部分和后半部分链表了
        //此时slow已经完全翻转了
        //slow指向后半部分的开头节点，pre指向前半部分的开始节点
        while (slow != null) {
            if (slow.val != pre.val) {
                return false;
            }
            slow = slow.next;
            pre = pre.next;
        }
        return true;
    }

    /**
     * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
     * <p>
     * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //初始化start和end都指向dummy。pre指每次要翻转的链表的头结点的上一个节点。
        // end指每次要翻转的链表的尾节点
        ListNode start = dummy, end = dummy;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            //如果要反转的链路长度小于k,则停止
            if (end == null) {
                break;
            }
            //记录下一个要反转的链表头
            ListNode next = end.next;
            //把链表断开
            end.next = null;

            //k个节点的链表头
            ListNode kHead = start.next;
            //翻转链表，start指向k个节点的前一个节点，链接上翻转之后的链表
            start.next = reverseList(kHead);

            //kHead已经变成了k个节点的尾部，链接上下一个要反转的链表头
            kHead.next = next;
            start = kHead;
            end = kHead;
        }
        return dummy.next;
    }
}
