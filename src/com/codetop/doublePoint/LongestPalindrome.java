package com.codetop.doublePoint;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String s = "a";
        longestPalindrome(s);
    }

    /**
     * 双指针法-中心扩散
     * 如果回文串的长度为奇数，则它有一个中心字符；如果回文串的长度为偶数，则可以认为它有两个中心字符
     */
    public static String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = palindrome(s, i, i);
            String s2 = palindrome(s, i, i + 1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    // 在 s 中寻找以 s[l] 和 s[r] 为中心的最长回文串
    public static String palindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && l <= r && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }
}
