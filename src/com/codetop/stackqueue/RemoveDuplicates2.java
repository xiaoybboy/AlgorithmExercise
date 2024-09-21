package com.codetop.stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1209. 删除字符串中的所有相邻重复项 II
 * 给你一个字符串 s，「k 倍重复项删除操作」将会从 s 中选择 k 个相邻且相等的字母，并删除它们，使被删去的字符串的左侧和右侧连在一起
 * 你需要对 s 重复进行无限次这样的删除操作，直到无法继续为止。
 * 在执行完所有删除操作后，返回最终得到的字符串。
 */
public class RemoveDuplicates2 {

    public String removeDuplicates(String s, int k) {
        Deque<Character> characters = new ArrayDeque<>();
        Deque<Integer> count = new ArrayDeque<>();

        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            //如果跟当前栈顶元素不同
            if (characters.isEmpty() || characters.peek() != ch) {
                characters.push(ch);
                count.push(1);
                continue;
            }
            //如果跟当前栈顶字符相同
            int curCount = count.peek() + 1;
            if (curCount < k) {
                characters.push(ch);
                count.push(curCount);
            } else {
                for (int j = 0; j < k - 1; j++) {
                    characters.pop();
                    count.pop();
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!characters.isEmpty()) {
            builder.append(characters.pollLast());
        }
        return builder.toString();
    }
}
