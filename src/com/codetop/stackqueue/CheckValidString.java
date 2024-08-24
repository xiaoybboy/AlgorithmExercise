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
        //这里要存的是下标，因为有顺序限制
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack1.push(i);
            } else if (ch == ')') {
                //优先从stack1中匹配
                if (!stack1.isEmpty()) {
                    stack1.pop();
                } else if (!stack2.isEmpty()) {
                    //stack1中没有，从stack2匹配
                    stack2.pop();
                } else {
                    //如果没有对应的左括号，返回false
                    return false;
                }
            } else {
                //*
                stack2.push(i);
            }
        }
        //判断stack1中的左括号能不能全部匹配
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int index1 = stack1.pop();
            int index2 = stack2.pop();
            if (index1 > index2) {
                return false;
            }
        }
        return stack1.isEmpty();
    }
}
