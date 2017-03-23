package com.test;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Vector;

/**
 * 输入一个链表，从尾到头打印链表每个节点的值 思路：利用stack栈的特点，先把链表中节点的值压入栈，然后出栈。
 * 
 * @author XIAO
 *
 *         public class ListNode { int val; ListNode next = null;
 *
 *         ListNode(int val) { this.val = val; } }
 */

public class PrintListReverse {
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		Stack<Integer> stack = new Stack<>();
		while (listNode != null) {
			stack.push(listNode.val);
		}
		ArrayList<Integer> list = new ArrayList<>();
		while (!stack.isEmpty()) {
			list.add(stack.pop());
		}
		return list;
	}
}
