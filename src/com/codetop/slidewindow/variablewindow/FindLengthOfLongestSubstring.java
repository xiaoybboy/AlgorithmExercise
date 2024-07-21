package com.codetop.slidewindow.variablewindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 */
public class FindLengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int maxLength = 0;

        Map<Character, Integer> map = new HashMap<>();
        //start 记录不重复元素左侧创建的最大位置
        int start = 0;
        //map的key存字符，value存不重复的字符的下标
        for (int end = 0; end < length; end++) {
            char endChar = s.charAt(end);
            if (map.containsKey(endChar)) {
                start = Math.max(start, map.get(endChar) + 1);
            }
            maxLength = Math.max(maxLength, end - start + 1);
            map.put(endChar, end);
        }
        return maxLength;
    }
}
