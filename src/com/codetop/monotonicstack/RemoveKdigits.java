package com.codetop.monotonicstack;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
 */
public class RemoveKdigits {

    public static void main(String[] args) {
        String num = "1432219";
        removeKdigits(num, 5);
    }

    public static String removeKdigits(String num, int k) {
        int n = num.length();
        if (k >= n) {
            return "0";
        }
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char cur = num.charAt(i);
            while (!deque.isEmpty() && cur < deque.peek() && k > 0) {
                deque.pop();
                k--;
            }
            //这里是为了排查前置0的影响
            if (cur != '0' || !deque.isEmpty()) {
                deque.push(cur);
            }
        }
        //如果栈已经正序排列了，k还没有用完，从后删除最大的数
        while (k > 0 && !deque.isEmpty()) {
            deque.pop();
            k--;
        }
        StringBuilder builder = new StringBuilder();
        while (!deque.isEmpty()) {
            builder.append(deque.pollLast());
        }
        return builder.length() == 0 ? "0" : builder.toString();
    }
}
