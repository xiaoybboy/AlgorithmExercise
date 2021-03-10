package com.sword.offer;

import com.model.ListNode;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 * <p>
 * 思路：初始化：3个指针
 * 1）pre指针指向已经反转好的链表的最后一个节点，最开始没有反转，所以指向nullptr
 * 2）cur指针指向待反转链表的第一个节点，最开始第一个节点待反转，所以指向head
 * 3）nex指针指向待反转链表的第二个节点，目的是保存链表，因为cur改变指向后，后面的链表则失效了，所以需要保存
 * 接下来，循环执行以下三个操作
 * 1）nex = cur->next, 保存作用
 * 2）cur->next = pre 未反转链表的第一个节点的下个指针指向已反转链表的最后一个节点
 * 3）pre = cur， cur = nex; 指针后移，操作下一个未反转链表的第一个节点
 * 循环条件，当然是cur != nullptr
 * 循环结束后，cur当然为nullptr，所以返回pre，即为反转后的头结点
 */
public class ReverseListNode {

    /**
     * 翻转链表
     *
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
        // 判断链表为空或长度为1的情况
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = null; // 当前节点的前一个节点
        ListNode next = null; // 当前节点的下一个节点
        while( head != null){
            next = head.next; // 记录当前节点的下一个节点位置；
            head.next = pre; // 让当前节点指向前一个节点位置，完成反转
            pre = head; // pre 往右走
            head = next;// 当前节点往右继续走
        }
        return pre;
    }
}
