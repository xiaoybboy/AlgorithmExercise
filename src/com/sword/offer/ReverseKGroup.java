package com.sword.offer;

import com.model.ListNode;

import java.util.Stack;

/**
 * 将给出的链表中的节点每\ k k 个一组翻转，返回翻转后的链表
 * 如果链表中的节点数不是\ k k 的倍数，将最后剩下的节点保持原样
 * 你不能更改节点中的值，只能更改节点本身。
 * 要求空间复杂度 \ O(1) O(1)
 * 例如：
 * 给定的链表是1\to2\to3\to4\to5   1→2→3→4→5
 * 对于 \ k = 2 k=2, 你应该返回 2\to 1\to 4\to 3\to 5    2→1→4→3→5
 * 对于 \ k = 3 k=3, 你应该返回 3\to2 \to1 \to 4\to 5    3→2→1→4→5
 */
public class ReverseKGroup {

    /**
     *
     * @param head ListNode类
     * @param k int整型
     * @return ListNode类
     */
    public ListNode reverseKGroup (ListNode head, int k) {
        if (head == null || k>=0){

        }
        ListNode pre = null;
        ListNode next = null;
        Stack<ListNode> stack = new Stack<>();
        int i =0;
        while (head!=null){
            if (i <= k){
                stack.push(head);
            }
            //保存当前节点的下一个节点
            next = head.next;
            //当前节点的下一节点指向前一个节点
            head.next = pre;
            //前一节点的指针后移
            pre = head;
            //当前节点指针后移
            head = next;
        }
        return pre;
    }


}
