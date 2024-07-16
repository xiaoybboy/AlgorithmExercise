package com.codetop.slidewindow.fixwindow;

/**
 * 给你字符串 s 和整数 k 。
 * <p>
 * 请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
 * <p>
 * 英文中的 元音字母 为（a, e, i, o, u）。
 */
public class MaxVowels {

    public int maxVowels(String s, int k) {
        int n = s.length();
        int vowel_count = 0;
        for (int i = 0; i < k; i++) {
            vowel_count += isVowel(s.charAt(i));
        }
        int ans = vowel_count;
        //窗口滑动
        for (int j = k; j < n; j++) {
            vowel_count = vowel_count - isVowel(s.charAt(j - k)) + isVowel(s.charAt(j));
            ans = Math.max(ans, vowel_count);
        }
        return ans;
    }

    private int isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ? 1 : 0;
    }
}
