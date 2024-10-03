package com.codetop.monotonicstack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的
 * 字典序最小（要求不能打乱其他字符的相对位置）。
 */
public class RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        //1.记录每个字符出现的次数
        int[] chCount = new int[256];
        for (char c : s.toCharArray()) {
            chCount[c]++;
        }
        //deque中单调自增的字符,从栈底到栈顶是单调递增的
        Deque<Character> deque = new ArrayDeque<>();
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            // 每遍历过一个字符，都将对应的计数减一
            chCount[c]--;
            //已经出现过的字符，跳过。不可能字典序比当前的小
            if (set.contains(c)) continue;
            //如果字典序比当前小，弹出栈元素
            //注意要同时比较，栈内元素是否在后面还有，如果没有的话，不能弹出
            while (!deque.isEmpty() && c < deque.peek() && chCount[deque.peek()] > 0) {
                char ch = deque.pop();
                set.remove(ch);
            }
            deque.push(c);
            set.add(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.pollLast());
        }
        return sb.toString();
    }
}
