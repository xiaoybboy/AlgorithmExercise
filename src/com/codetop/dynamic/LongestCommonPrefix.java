package com.codetop.dynamic;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""
 */
public class LongestCommonPrefix {
    /**
     * 依次比较每个字符串的前面是否相等
     */
    public String longestCommonPrefix(String[] strs) {
        int n = strs[0].length();
        for (int i = 0; i < n; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                //比较这些字符的前面是否相等
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return "";
    }
}
