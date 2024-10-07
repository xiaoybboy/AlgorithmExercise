package com.codetop;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 给定一个字符串 s ，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 * <p>
 * 返回 s 的任意可能的重新排列。若不可行，返回空字符串 "" 。
 */
public class ReorganizeString {

    public class Node {
        char ch;
        Integer count = 0;

        public Node() {
        }

        public Node(char ch, Integer count) {
            this.ch = ch;
            this.count = count;
        }
    }

    public String reorganizeString(String s) {
        char[] arrays = s.toCharArray();
        Map<Character, Node> map = new HashMap<>();
        for (char c : arrays) {
            Node node = map.getOrDefault(c, new Node());
            node.ch = c;
            node.count += 1;
            map.put(c, node);
        }
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o2.count - o1.count);
        for (Node node : map.values()) {
            queue.offer(node);
        }
        StringBuilder builder = new StringBuilder();
        //出现频次最高的元素和出现频次第二高的元素，依次出队和入队
        while (!queue.isEmpty()) {
            Node first = queue.poll();
            Node second = queue.poll();
            //出现次数第一高的元素
            builder.append(first.ch);
            first.count--;
            if (first.count > 0) {
                queue.offer(first);
            }
            //出现次数第二高的元素，有可能为空
            if (second != null) {
                builder.append(second.ch);
                second.count--;
                if (second.count > 0) {
                    queue.offer(second);
                }
            } else {
                break;
            }
        }
        return builder.length() == s.length() ? builder.toString() : "";
    }
}
