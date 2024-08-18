package com.codetop.slidewindow.fixwindow;

/**
 * 给你字符串 s 和整数 k 。
 * <p>
 * 请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
 * <p>
 * 英文中的 元音字母 为（a, e, i, o, u）。
 */
public class MaxVowels {

    public static void main(String[] args) {
        String s = "ibpbhixfiouhdljnjfflpapptrxgcomvnb";
        maxVowels(s, 33);
    }

    public static int maxVowels(String s, int k) {
        int n = s.length();
        int start = 0, end = 0, count = 0;
        int ans = 0;
        while (end < n) {
            //窗口大小不满足k
            if (end < k) {
                count += isVowel(s.charAt(end));
            } else {
                //窗口移动，不断更新中间变量的值
                count = count + isVowel(s.charAt(end)) - isVowel(s.charAt(start));
                start++;
            }
            //更新最终结果
            ans = Math.max(ans, count);
            end++;
        }
        return ans;
    }

    private static int isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ? 1 : 0;
    }
}
