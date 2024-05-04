package com.codetop.recursion;

/**
 * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
 * <p>
 * 如果不存在这样的子字符串，则返回 0。
 */
public class LongestSubstring {

    /**
     * 递归
     */
    public int longestSubstring(String s, int k) {
        final int n = s.length();
        // 特殊情况处理
        if (k == 1) {
            return n;
        }
        if (k > n) {
            return 0;
        }
        // 统计整个字符串的字符个数
        int[] counts = new int[26];
        for (char ch : s.toCharArray()) {
            counts[ch - 'a']++;
        }

        // 寻找字符个数小于k的字符
        for (int i = 0; i < 26; i++) {
            if (counts[i] > 0 && counts[i] < k) {
                int res = 0;
                char ch = (char) (i + 'a');
                // 用这个字符把整个字符串分隔为几个部分，问题的解不可能超出这几个子部分
                for (String ss : s.split(String.valueOf(ch))) {
                    // 递归处理每个部分
                    res = Math.max(res, longestSubstring(ss, k));
                }
                // 子部分的最值就是问题的解
                // 并且这里，只要找到一个分隔字符即可，其余的在子问题中会得到处理。不需要过多的陷入递归嵌套之中。
                return res;
            }
        }

        // 没有找到小于k的字符，说明整个字符串都符合要求，返回其长度
        return n;
    }
}
