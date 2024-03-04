package com.codetop.dynamic;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 */
public class LongestPalindrome {

    /**
     * /**
     * * 首先定义：字符串 s 从下标 i 到下标 j 的字串为 P(i, j)，若 s 从下标 i 到下标 j 的字串为回文串，则 P(i, j) =
     * true，
     * * 否则 P(i, j) = false。
     * *
     * <p>
     * * P(i, j) = (P(i + 1, j - 1) && s[i] == s[j])。
     * *
     * <p>
     * * 求 长度为 1 和长度为 2 的 P(i, j) 时不能用上边的公式，因为我们代入公式后会遇到 P[i][j] 中 i > j
     * 的情况，比如求P[1][2] 的话，
     * * 我们需要知道 P[1+1][2-1]=P[2][1] ，而 P[2][1] 代表着 S[2, 1]
     * 是不是回文串，这显然是不对的，所以我们需要单独判断。
     * <p>
     * 已知对角线都是true(i=j 单字母),i>j的情况都是false(i>j是非法情况)，从左上角，往右下角遍历
     * 即：从i=0开始，依次填充列的值。由于dp[i][j]依赖dp[i+1][j-1],右上角的值，依赖左下角的值
     * 当遍历到dp[i][j]的时候，左下角的值一定已经被填充了
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int sLen = s.length();
        int maxLen = 0;
        String ans = "";
        boolean[][] P = new boolean[sLen][sLen];
        // len 要放前面，因为为了计算P[start + 1][end - 1]
        for (int len = 1; len <= sLen; len++) {
            for (int start = 0; start < sLen; start++) {
                int end = start + len - 1;
                if (end >= sLen) {
                    break;
                }
                // 计算P[start][end]
                P[start][end] = (len == 1 || len == 2 || P[start + 1][end - 1]) && s.charAt(start) == s.charAt(end);
                if (P[start][end] && len > maxLen) {
                    maxLen = len;
                    ans = s.substring(start, end + 1);
                }
            }
        }
        return ans;
    }
}
