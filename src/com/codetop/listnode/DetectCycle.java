package com.codetop.listnode;

import com.model.ListNode;

/**
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）
 * 。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 */
public class DetectCycle {

    /**
     * b,c 根据相遇点分成的两部分
     * a + b（环） + c(环)(b是环上快慢指针的相遇点)
     * <p>
     * 1.fast = a + n(b + c)+b
     * 2.slow = a + b
     * 3.fast = 2slow
     * a + n(b + c)+b = 2(a+b)
     * a = c + (n-1)(b+c)
     * 也就是说，从第一次相遇点往后. fast指向head,fast和slow一起前进的话，fast走了a,此时slow走c+(n-1)(b+c)
     * 刚好到达环的入口处
     * <p>
     */
    public ListNode detectCycle2(ListNode head) {
        //1.快慢指针法，得到环的位置
        ListNode fast = head, slow = head;
        while (true) {
            //fast,slow没有相遇，这时没有环
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        //2.fast指向头节点，和slow一起移动,当两者相遇时，就是环的入口
        fast = head;
        while (fast == slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    /**
     * 监测链路表中是否包含环
     */
    private boolean hasCycle(ListNode head) {
        // 快慢指针初始化指向 head
        ListNode slow = head, fast = head;
        // 快指针走到末尾时停止
        while (fast != null && fast.next != null) {
            // 慢指针走一步，快指针走两步
            slow = slow.next;
            fast = fast.next.next;
            // 快慢指针相遇，说明含有环
            if (slow == fast) {
                return true;
            }
        }
        // 不包含环
        return false;
    }
}
