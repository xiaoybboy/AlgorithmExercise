package com.offer1;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * <p>
 * <分析>：
 * 入队：将元素进栈A
 * 出队：判断栈B是否为空，如果为空，则将栈A中所有元素pop，并push进栈B，栈B出栈； 如果不为空，栈B直接出栈。
 *
 * @author XIAO
 */

import java.util.Stack;

public class TwoStackQueue {
    
    Stack<Integer> stackA = new Stack<Integer>();
    Stack<Integer> stackB = new Stack<Integer>();

    public void push(int node) {
        stackA.push(node);
    }

    /**
     * 如果 B不为空，直接出栈。如果为空，把A中元素先出栈，再压栈到B
     *
     * @return
     */
    public int pop() {
        int a;
        if (!stackB.isEmpty()) {
            a = stackB.pop();
        } else {
            while (!stackA.isEmpty()) {
                stackB.push(stackA.pop());
            }
            a = stackB.pop();
        }
        return a;
    }
}
