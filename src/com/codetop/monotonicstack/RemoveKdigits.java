package com.codetop.monotonicstack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
 */
public class RemoveKdigits {

    public String removeKdigits(String num, int k) {
        if (num.length() <= k) {
            return "0";
        }
        //stack中保留最终要留的字符
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            //如果之前已经有字符大于当前字符，那么一定要移除
            while (!stack.isEmpty() && k > 0 && stack.peek() > ch) {
                stack.pop();
                k--;
            }
            //去除前导0
            if (ch != '0' || !stack.isEmpty()) {
                stack.push(ch);
            }
        }
        // k仍不为 0，处理
        while (k-- > 0 && !stack.isEmpty()) {
            stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        String res = sb.toString();
        return "".equals(res) ? "0" : res;
    }
}
