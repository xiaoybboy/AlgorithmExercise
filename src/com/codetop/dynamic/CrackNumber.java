package com.codetop.dynamic;

/**
 * 现有一串神秘的密文 ciphertext，经调查，密文的特点和规则如下：
 * <p>
 * 密文由非负整数组成
 * 数字 0-25 分别对应字母 a-z
 * 请根据上述规则将密文 ciphertext 解密为字母，并返回共有多少种解密结果。
 */
public class CrackNumber {
    /**
     * 类比青蛙跳问题
     * f[i] = f[i-1]+f[i-1]
     */
    public int crackNumber(int ciphertext) {
        String s = String.valueOf(ciphertext); // 将数字转为字符串
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 1;  //初始化
        for (int i = 1; i <= n; i++) {
            f[i] = f[i - 1];  //单独翻译s[i]
            if (i > 1) {
                int t = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
                if (t >= 10 && t <= 25) //组合的数字范围在10 ~ 25之间
                {
                    f[i] += f[i - 2]; //将s[i] 和 s[i - 1]组合翻译
                }
            }
        }
        return f[n];
    }
}
