package com.codetop;

import java.util.Stack;

/**
 * 给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，
 * 只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false 。
 * 1 2 3 4 5
 * 4 5 3 2 1
 */
public class ValidateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && popped[j] == stack.peek()) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
