package com.offer1;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 *
 * @author XIAO
 */
public class StackMin {

    Stack<Integer> stack1 = new Stack();
    Stack<Integer> stack2 = new Stack();

    public void push(int node) {
        stack1.push(node);
        if (stack2.isEmpty() || stack2.peek() >= node) {
            stack2.push(node);
        }
    }

    public void pop() {
        if (stack1.peek() == stack2.peek()) {
            stack1.pop();
            stack2.pop();
        } else {
            stack1.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}
