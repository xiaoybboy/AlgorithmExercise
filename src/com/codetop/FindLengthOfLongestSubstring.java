package com.codetop;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 获取字符串的最长不重复子串
 * 不含有重复字符的 最长子串 的长度
 */
public class FindLengthOfLongestSubstring {

    /**
     * map (k, v)，其中 key 值为字符，value 值为字符位置;
     * <p>
     * start不动，end向后移动
     * 当end遇到重复字符，start应该放在上一个重复字符的位置的后一位，同时记录最长的长度
     * 怎样判断是否遇到重复字符，且怎么知道上一个重复字符的位置？--用哈希字典的key来判断是否重复，用value来记录该字符的下一个不重复的位置。
     */
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int maxLength = 0;

        Map<Character, Integer> map = new HashMap<>();
        //map的key存字符，value存不重复的字符的下标
        for (int start = 0, end = 0; end < length; end++) {
            char endChar = s.charAt(end);
            if (map.containsKey(endChar)) {
                start = Math.max(start, map.get(endChar) + 1);
            }
            maxLength = Math.max(maxLength, end - start + 1);
            map.put(endChar, end);
        }
        return maxLength;
    }


    public int lengthOfLongestSubstring2(String s) {
        Set<Character> set = new HashSet<>();
        int start = 0;
        int ans = 0;
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            while (set.contains(ch)) {
                set.remove(s.charAt(start));
                start++;
            }
            set.add(ch);
            ans = Math.max(ans, end - start + 1);
        }
        return ans;
    }
}
