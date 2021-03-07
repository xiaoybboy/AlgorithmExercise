package com.offer1;

import com.model.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个链表，从尾到头打印链表每个节点的值 思路：利用stack栈的特点，先把链表中节点的值压入栈，然后出栈。
 *
 * @author XIAO
 * <p>
 * public class ListNode { int val; ListNode next = null;
 * <p>
 * ListNode(int val) { this.val = val; } }
 */

public class PrintListNodeReverse {
    /**
     * 方法1：使用栈
     *
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

    /**
     * 使用list的函数，每次在头部插入
     *
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListNodeFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        while (listNode != null) {
            list.add(0, listNode.val);
            listNode = listNode.next;
        }
        return list;
    }
}
