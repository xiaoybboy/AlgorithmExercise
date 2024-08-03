package com.codetop.slidewindow.variablewindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 s ，它只包含三种字符 a, b 和 c 。
 * <p>
 * 请你返回 a，b 和 c 都 至少 出现过一次的子字符串数目。
 */
public class NumberOfSubstrings {

    public int numberOfSubstrings(String s) {
        int start = 0;
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while (map.getOrDefault('a', 0) > 0 && map.getOrDefault('b', 0) > 0 && map.getOrDefault('c', 0) > 0) {
                char startC = s.charAt(start);
                map.put(startC, map.getOrDefault(startC, 0) - 1);
                start++;
            }
            result += start;
        }
        return result;
    }
}
