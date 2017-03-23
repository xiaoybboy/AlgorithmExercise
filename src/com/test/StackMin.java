package com.test;

import java.util.Iterator;
import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * 
 * @author XIAO
 *
 */
public class StackMin {

	Stack<Integer> stack = new Stack<>();// 定义一个栈

	public void push(int node) {
		stack.push(node);
	}

	public void pop() {
		stack.pop();
	}

	public int top() {
		return stack.peek();
	}

	// 一个简单的排序
	public int min() {
		int min = stack.peek();
		int temp = 0;
		Iterator<Integer> iterator = stack.iterator();
		while (iterator.hasNext()) {
			temp = iterator.next();
			if (temp < min) {
				min = temp;
			}
		}
		return min;

	}
}
