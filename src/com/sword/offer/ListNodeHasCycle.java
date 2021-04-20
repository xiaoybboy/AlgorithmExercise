package com.sword.offer;

import com.model.ListNode;

/**
 * 判断给定的链表中是否有环。如果有环则返回true，否则返回false。
 * 你能给出空间复杂度O(1)的解法么？
 * <p>
 * 思路：1.常规思路 Set判断
 * 2.快慢指针法：慢指针每次走一步，快指针每次走两步，如果相遇就说明有环，如果有一个为空说明没有环。代码比较简单
 */
public class ListNodeHasCycle {

    /**
     * 快慢指针法判断链表是否有环
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            //慢指针每次走一步
            slow = slow.next;
            //快指针每次走两步
            fast = fast.next.next;
            //如果相遇，说明有环，直接返回true
            if (slow == fast)
                return true;
        }
        return false;
    }
}
