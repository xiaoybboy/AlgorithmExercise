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

    public String reorganizeString(String s) {
        //1.统计每个字符出现的次数
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        //2,构造最大堆
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        for (Map.Entry<Character, Integer> m : map.entrySet()) {
            maxHeap.add(m);
        }
        //3.每次取出频率最高的元素，然后后面插入一个其他元素，直到队列元素用完
        //注意：如果最后没有与频率最高的元素匹配的其他字符，最高频元素会全部弹出，整个字符串的长度会小于s的长度
        StringBuilder builder = new StringBuilder();
        Map.Entry<Character, Integer> pre = null;
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> cur = maxHeap.poll();
            //注意这里，因为上一轮已经把频率最高的元素弹出了，这里取出来的是频率第二高的元素
            if (pre != null && pre.getValue() > 0) {
                maxHeap.offer(pre);
            }
            //插入一个最高频元素，然后插入一个次高频元素
            builder.append(cur.getKey());
            cur.setValue(cur.getValue() - 1);
            pre = cur;
        }
        return builder.length() == s.length() ? builder.toString() : "";
    }
}
