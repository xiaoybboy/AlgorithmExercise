package com.codetop.dynamic;

/**
 * 现有一串神秘的密文 ciphertext，经调查，密文的特点和规则如下：
 * 密文由非负整数组成
 * 数字 0-25 分别对应字母 a-z
 * 请根据上述规则将密文 ciphertext 解密为字母，并返回共有多少种解密结果。
 */
public class CrackNumber {

    public static void main(String[] args) {
        int n = 216612;
        crackNumber(n);
    }

    //dp[i] = dp[i-1] 如果单位
    //dp[i] = dp[i-1] + dp[i-2]
    public static int crackNumber(int ciphertext) {
        String s = String.valueOf(ciphertext);
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];
            //如果能拆分成2位
            if (i > 1) {
                int val = Integer.parseInt(s.substring(i - 2, i));
                if (val <= 25 && val >= 10) {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[n];
    }
}
