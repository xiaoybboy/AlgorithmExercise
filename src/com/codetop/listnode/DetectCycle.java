package com.codetop.listnode;

import com.model.ListNode;

/**
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）
 * 。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 */
public class DetectCycle {

    /**
     * 我们使用两个指针，fast\textit{fast}fast 与 slow\textit{slow}slow。它们起始都位于链表的头部。随后，slow\textit{slow}slow 指针每次向后移动一个位置，而 fast\textit{fast}fast 指针向后移动两个位置。如果链表中存在环，则 fast\textit{fast}fast 指针最终将再次与 slow\textit{slow}slow 指针在环中相遇。
     *
     * 如下图所示，设链表中环外部分的长度为 aaa。slow\textit{slow}slow 指针进入环后，又走了 bbb 的距离与 fast\textit{fast}fast 相遇。此时，fast\textit{fast}fast 指针已经走完了环的 nnn 圈，因此它走过的总距离为 a+n(b+c)+b=a+(n+1)b+nca+n(b+c)+b=a+(n+1)b+nca+n(b+c)+b=a+(n+1)b+nc。
     *
     *
     *
     * 根据题意，任意时刻，fast\textit{fast}fast 指针走过的距离都为 slow\textit{slow}slow 指针的 222 倍。因此，我们有
     *
     * a+(n+1)b+nc=2(a+b)  ⟹  a=c+(n−1)(b+c)a+(n+1)b+nc=2(a+b) \implies a=c+(n-1)(b+c)
     * a+(n+1)b+nc=2(a+b)⟹a=c+(n−1)(b+c)
     * 有了 a=c+(n−1)(b+c)a=c+(n-1)(b+c)a=c+(n−1)(b+c) 的等量关系，我们会发现：从相遇点到入环点的距离加上 n−1n-1n−1 圈的环长，恰好等于从链表头部到入环点的距离。
     *
     * 因此，当发现 slow\textit{slow}slow 与 fast\textit{fast}fast 相遇时，我们再额外使用一个指针 ptr\textit{ptr}ptr。起始，它指向链表头部；随后，它和 slow\textit{slow}slow 每次向后移动一个位置。最终，它们会在入环点相遇。
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
