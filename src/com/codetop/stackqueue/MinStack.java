package com.codetop.stackqueue;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> min_stack;

    public MinStack() {
        stack = new Stack<>();
        min_stack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (min_stack.isEmpty() || val <= min_stack.peek()) {
            min_stack.push(val);
        }
    }

    public void pop() {
        int x = stack.pop();
        if (!min_stack.isEmpty() && x == min_stack.peek()) {
            min_stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min_stack.peek();
    }
}
