package com.baseAlgorithm;

public class IntDictionarySort {
    public String longestPalindrome(String s) {
        //dp[i][j] = s[i] == s[j] && dp[i+1][j-1]
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        int maxLength = 0;
        String longestPalindrome = "";
        for (int end = 1; end < n; end++) {
            for (int start = 0; start < end; start++) {
                if (s.charAt(start) == s.charAt(end)) {
                    dp[start][end] = (end - start <= 1) || dp[start + 1][end - 1];
                    if (dp[start][end] && (end - start + 1) > maxLength) {
                        longestPalindrome = s.substring(start, end);
                    }
                }
            }
        }
        return longestPalindrome;
    }

}
