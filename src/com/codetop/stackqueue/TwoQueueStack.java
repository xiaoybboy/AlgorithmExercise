package com.codetop.stackqueue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 用两个队列实现栈的功能； 思路 <分析>：把B当做一个中转站 入栈：将元素进队列A
 * 出栈：判断队列A中元素的个数是否为1，如果等于1，则出队列，否则将队列A中的元素出队列并放入队列B，直到队列A中的元素留下一个， 然后队列A出队列，再把
 * 队列B中的元素出队列以此放入队列A中。
 *
 * @author XIAO
 */
public class TwoQueueStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public TwoQueueStack() {
        queue1 = new ArrayDeque<>();
        queue2 = new ArrayDeque<>();
    }

    public void push(int x) {
        queue1.offer(x);
        while (!queue2.isEmpty()) {
            queue1.offer(queue2.poll());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public int pop() {
        return queue2.poll();
    }

    public int top() {
        return queue2.peek();
    }

    public boolean empty() {
        return queue2.isEmpty();
    }
}
