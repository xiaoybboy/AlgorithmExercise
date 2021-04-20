package com.sword.offer;

import java.util.Stack;

/**
 * 给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
 * 括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。
 * <p>
 * 1.栈 遇到(,{,[ 就压栈，遇到右括号就出栈。取栈时判断一下是不是对应的括号，如果是就取栈成功，不是就不能取。
 * <p>
 * 2.字符替换法
 */
public class IsValidBrackets {

    /**
     * @param s string字符串
     * @return bool布尔型
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.empty()) {
                stack.push(s.charAt(i));
                continue;
            }
            if (s.charAt(i) == ')' && stack.peek() == '(') {
                stack.pop();
            } else if (s.charAt(i) == '}' && stack.peek() == '{') {
                stack.pop();
            } else if (s.charAt(i) == ']' && stack.peek() == '[') {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        //如果最后栈为空，表示符合要求
        return stack.empty();
    }
}
