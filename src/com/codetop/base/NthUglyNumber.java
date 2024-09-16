package com.codetop.base;

/**
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 * <p>
 * 丑数 就是质因子只包含 2、3 和 5 的正整数。
 */
public class NthUglyNumber {

    public int nthUglyNumber(int n) {
        int[] res = new int[n];
        res[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; i++) {
            int n2 = res[p2] * 2, n3 = res[p3] * 3, n5 = res[p5] * 5;
            res[i] = Math.min(Math.min(n2, n3), n5);
            if (res[i] == n2) p2++;
            if (res[i] == n3) p3++;
            if (res[i] == n5) p5++;
        }
        return res[n-1];
    }
}
