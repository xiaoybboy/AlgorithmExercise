package com.top200;

/**
 * 对于一个字符串，请设计一个高效算法，计算其中最长回文子串的长度。
 * <p>
 * 给定字符串A以及它的长度n，请返回最长回文子串的长度。
 * <p>
 * 思路：动态规划
 * <p>
 * 定义二维数组dp[length][length]，如果dp[left][right]为true，则表示字符串从left到right是回文子串，如果dp[left][right]为false，
 * 则表示字符串从left到right不是回文子串。
 * 如果dp[left+1][right-1]为true，我们判断s.charAt(left)和s.charAt(right)是否相等，如果相等，那么dp[left][right]肯定也是回文子串，
 * 否则dp[left][right]一定不是回文子串。
 * <p>
 * 所以我们可以找出递推公式
 * dp[left][right]=s.charAt(left)==s.charAt(right)&&dp[left+1][right-1]
 * <p>
 * 有了递推公式，还要确定边界条件：
 * 如果s.charAt(left)！=s.charAt(right)，那么字符串从left到right是不可能构成子串的，直接跳过即可。
 * 如果s.charAt(left)==s.charAt(right)，字符串从left到right能不能构成回文子串还需要进一步判断
 * 1.如果right-left<=2，类似于"aa"，或者"aba"，我们认为他是回文子串。即dp[left][right]=true（right-left<=2）
 * 2.如果right-left>2，我们只需要判断dp[left+1][right-1]是否是回文子串，才能确定dp[left][right]是否为true还是false。
 * 即dp[left][right]=dp[left+1][right-1]
 */
public class GetLongestPalindrome {

    /**
     * 获得最长回文串的长度
     *
     * @param A
     * @param n 字符串长度
     * @return
     */
    public int getLongestPalindrome(String A, int n) {
        if (n <= 2) {
            return n;
        }

        //记录最长回文串的长度
        int maxLength = 1;
        boolean[][] dp = new boolean[n][n];

        //由于先循环的right，所以递推公式中的dp[left + 1][right - 1]一定计算过了
        for (int right = 1; right < n; right++) {
            for (int left = 0; left < right; left++) {
                if (A.charAt(left) != A.charAt(right)) {
                    dp[left][right] = false;
                    continue;
                }

                if (right - left <= 2) {
                    dp[left][right] = true;
                } else {
                    dp[left][right] = dp[left + 1][right - 1];
                }

                //如果字符串从left到right是回文子串，只需要保存最长的即可
                if (dp[left][right] && right - left + 1 > maxLength) {
                    maxLength = right - left + 1;
                }
            }
        }
        return maxLength;
    }
}
