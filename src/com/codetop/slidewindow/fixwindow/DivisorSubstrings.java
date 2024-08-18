package com.codetop.slidewindow.fixwindow;

/**
 * 一个整数 num 的 k 美丽值定义为 num 中符合以下条件的 子字符串 数目：
 * <p>
 * 子字符串长度为 k 。
 * 子字符串能整除 num 。
 * 给你整数 num 和 k ，请你返回 num 的 k 美丽值。
 * 注意：
 * 允许有 前缀 0 。
 * 0 不能整除任何值。
 * 一个 子字符串 是一个字符串里的连续一段字符序列。
 */
public class DivisorSubstrings {

    public int divisorSubstrings(int num, int k) {
        String numS = String.valueOf(num);
        int n = numS.length();
        if (n < k) {
            return 0;
        }

        int start = 0, end = k;
        int ans = 0;
        while (end <= n) {
            int temp = Integer.parseInt(numS.substring(start, end));
            if (temp != 0 && num % temp == 0) {
                ans++;
            }
            end++;
            start++;
        }
        return ans;
    }
}
