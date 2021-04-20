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

    public ListNode reverseKGroup(ListNode head, int k) {
        //定义一个栈
        Stack<ListNode> stack = new Stack<ListNode>();
        //初始化一个新的链表存放结果
        ListNode ret = new ListNode(0);
        //为新链表定义一个指针,防止后续操作改变链表头节点
        ListNode p = ret;
        //循环原有链表
        while (true) {
            //为每次反转计数
            int count = 0;
            //定义指针操作原始链表
            ListNode tmp = head;
            //循环入栈
            while (tmp != null && count < k) {
                stack.push(tmp);
                tmp = tmp.next;
                count++;
            }
            //判断该次反转是否达到要求，此处防止因tem==null跳出循环的条件
            if (count != k) {
                //表示剩下的节点不够k个，直接将剩余节点插入末尾结束
                p.next = head;
                break;
            }
            //出栈操作，反转链表
            while (!stack.isEmpty()) {
                p.next = stack.pop();
                p = p.next;
            }
            //重置下一次操作的初始节点
            p.next = tmp;
            head = tmp;
        }
        return ret.next;
    }
}
