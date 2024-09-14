package com.codetop.stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给你一个只包含三种字符的字符串，支持的字符类型分别是 '('、')' 和 '*'。请你检验这个字符串是否为有效字符串，如果是 有效 字符串返回 true 。
 * <p>
 * 有效 字符串符合如下规则：
 * 任何左括号 '(' 必须有相应的右括号 ')'。
 * 任何右括号 ')' 必须有相应的左括号 '(' 。
 * 左括号 '(' 必须在对应的右括号之前 ')'。
 * '*' 可以被视为单个右括号 ')' ，或单个左括号 '(' ，或一个空字符串 ""。
 */
public class CheckValidString {

    public boolean checkValidString(String s) {
        Deque<Integer> deque1 = new ArrayDeque<>();
        Deque<Integer> deque2 = new ArrayDeque<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                deque1.push(i);
            } else if (ch == ')') {
                //优先从stack1中取
                if (!deque1.isEmpty()) {
                    deque1.pop();
                } else if (!deque2.isEmpty()) {
                    deque2.pop();
                } else {
                    return false;
                }
            } else if (ch == '*') {
                deque2.push(i);
            }
        }
        //判断stack1中的左括号能不能全部匹配
        while (!deque1.isEmpty() && !deque2.isEmpty()) {
            int index1 = deque1.pop();
            int index2 = deque2.pop();
            if (index1 > index2) {
                return false;
            }
        }
        return deque1.isEmpty();
    }
}
