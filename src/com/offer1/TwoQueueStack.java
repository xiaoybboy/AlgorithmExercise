package com.offer1;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 用两个队列实现栈的功能； 思路 <分析>：把B当做一个中转站 入栈：将元素进队列A
 *
 * 出栈：判断队列A中元素的个数是否为1，如果等于1，则出队列，否则将队列A中的元素出队列并放入队列B，直到队列A中的元素留下一个， 然后队列A出队列，再把
 * 队列B中的元素出队列以此放入队列A中。
 *  
 * @author XIAO
 *
 */
public class TwoQueueStack {
	Queue<Integer> queue1 = new ArrayDeque<>();
	Queue<Integer> queue2 = new ArrayDeque<>();

	public void push(int node) {
		// 两个栈都为空时，优先考虑queue1
		if (queue1.isEmpty() && queue2.isEmpty()) {
			queue1.add(node);
			return;
		}

		// 如果queue1为空，queue2有元素，直接放入queue2
		if (queue1.isEmpty()) {
			queue2.add(node);
			return;
		}

		if (queue2.isEmpty()) {
			queue1.add(node);
			return;
		}

	}

	public int pop() {
		// 两个栈都为空时，没有元素可以弹出
		if (queue1.isEmpty() && queue2.isEmpty()) {
			try {
				throw new Exception("stack is empty");
			} catch (Exception e) {
			}
		}
		// 如果queue1为空，queue2有元素， 将queue2的元素依次放入queue1中，直到最后一个元素，我们弹出。
		if (queue1.isEmpty()) {
			while (queue2.size() > 1) {
				queue1.add(queue2.poll());
			}
			return queue2.poll();
		}

		if (queue2.isEmpty()) {
			while (queue1.size() > 1) {
				queue2.add(queue1.poll());
			}
			return queue1.poll();
		}

		return (Integer) null;
	}
}
