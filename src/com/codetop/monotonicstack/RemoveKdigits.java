package com.codetop.monotonicstack;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
 */
public class RemoveKdigits {

    public static String removeKdigits(String num, int k) {
        char[] charArray = num.toCharArray();
        Deque<Character> deque = new ArrayDeque<>();
        int n = charArray.length;
        for (int i = 0; i < n; i++) {
            char ch = charArray[i];
            //移除前面比当前字符大的
            while (!deque.isEmpty() && deque.peek() > ch && k > 0) {
                deque.pop();
                k--;
            }
            //排除前置0
            if (!deque.isEmpty() || ch != '0') {
                deque.push(ch);
            }
        }
        //如果k还有值
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
