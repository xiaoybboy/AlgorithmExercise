package com.codetop.doublePoint;

/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 */
public class IsSubsequence {

    public static boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        int i = 0;
        for (int j = 0; j < t.length(); j++) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                // 若已经遍历完 s ，则提前返回 true
                if (i == s.length()) {
                    return true;
                }
            }
        }
        return false;
    }
}
