package com.codetop.recursion;

/**
 * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
 * <p>
 * 如果不存在这样的子字符串，则返回 0。
 */
public class LongestSubstring {

    public static void main(String[] args) {
        String s = "aaabb";
        longestSubstring(s, 3);
    }

    public static int longestSubstring(String s, int k) {
        int n = s.length();
        if (k == 1) {
            return n;
        }
        if (k > n) {
            return 0;
        }
        //统计整个字符串串中每个字符出现次数
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        //找到任意一个出现次数<k的字符，这个循环不用执行完，其他情况，在子问题中会自动处理
        //找到第一个即可
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0 && count[i] < k) {
                char ch = (char) ('a' + i);
                //按照这个字符串分割，并找到每个子串满足条件的最大长度
                String[] array = s.split(String.valueOf(ch));
                int res = 0;
                for (String s1 : array) {
                    res = Math.max(res, longestSubstring(s1, k));
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
