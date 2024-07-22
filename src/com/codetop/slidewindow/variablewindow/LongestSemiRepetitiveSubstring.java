package com.codetop.slidewindow.variablewindow;

/**
 * 给你一个下标从 0 开始的字符串 s ，这个字符串只包含 0 到 9 的数字字符。
 * <p>
 * 如果一个字符串 t 中至多有一对相邻字符是相等的，那么称这个字符串 t 是 半重复的 。
 * 例如，"0010" 、"002020" 、"0123" 、"2002" 和 "54944" 是半重复字符串，而 "00101022" （相邻的相同数字对是 00 和 22）和 "1101234883"
 * （相邻的相同数字对是 11 和 88）不是半重复字符串。
 * <p>
 * 请你返回 s 中最长 半重复
 * 子字符串
 * 的长度
 */
public class LongestSemiRepetitiveSubstring {

    public int longestSemiRepetitiveSubstring(String s) {
        int start = 0, result = 1;
        int tempLength = 0, n = s.length();
        for (int end = 1; end < n; end++) {
            if (s.charAt(end) == s.charAt(end - 1)) {
                tempLength++;
            }
            while (tempLength > 1 && start < n - 1) {
                //收缩左窗口
                if (s.charAt(start) == s.charAt(start + 1)) {
                    tempLength--;
                }
                start++;
            }
            result = Math.max(result, end - start + 1);
        }
        return result;
    }
}
