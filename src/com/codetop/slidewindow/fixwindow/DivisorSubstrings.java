package com.codetop.slidewindow.fixwindow;

/**
 * 一个整数 num 的 k 美丽值定义为 num 中符合以下条件的 子字符串 数目：
 * <p>
 * 子字符串长度为 k 。
 * 子字符串能整除 num 。
 * 给你整数 num 和 k ，请你返回 num 的 k 美丽值。
 * <p>
 * 注意：
 * <p>
 * 允许有 前缀 0 。
 * 0 不能整除任何值。
 * 一个 子字符串 是一个字符串里的连续一段字符序列。
 */
public class DivisorSubstrings {

    public int divisorSubstrings(int num, int k) {
        String numStr = String.valueOf(num);
        if (numStr.length() < k) {
            return 0;
        }
        int count = 0, n = numStr.length();
        int start = 0, end = k;
        while (end <= n) {
            int temp = Integer.valueOf(numStr.substring(start, end));
            if (temp != 0 && num % temp == 0) {
                count++;
            }
            start++;
            end++;
        }
        return count;
    }
}
