package com.codetop.base;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 */
public class IsValid {

    public boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                deque.push(ch);
            } else {
                if (deque.isEmpty() || !match(deque.peek(), ch)) {
                    return false;
                }
                deque.pop();
            }
        }
        return deque.isEmpty();
    }

    private boolean match(char c1, char c2) {
        if (c1 == '(') {
            return c2 == ')';
        } else if (c1 == '{') {
            return c2 == '}';
        } else {
            return c2 == ']';
        }
    }
}
