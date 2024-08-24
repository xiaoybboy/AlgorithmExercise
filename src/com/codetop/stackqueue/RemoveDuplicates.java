package com.codetop.stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 */
public class RemoveDuplicates {

    public String removeDuplicates(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!deque.isEmpty() && ch == deque.peek()) {
                deque.pop();
                continue;
            }
            deque.push(ch);
        }
        StringBuilder builder = new StringBuilder();
        while (!deque.isEmpty()) {
            builder.append(deque.pollLast());
        }
        return builder.toString();
    }
}
