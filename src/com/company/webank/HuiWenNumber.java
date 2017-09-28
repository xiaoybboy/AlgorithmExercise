package com.company.webank;

import java.util.Scanner;

/**
 * 题目描述：
 * 回文串是无论正着读还是反着读都一样的字符串，比如“level”或者“noon”就是回文串。
 * 若将某个十进制非负整数N，转换成二进制后得到的 01 序列具有回文串的性质，则称该数为回文数，比如十进制非负整数 9 表示成二进制后得到
 * 1001，“1001”具有回文串的性质，则称十进制整数 9 为回文数。
 * <p>
 * 现给你一个十进制整数N，请计算小于等于N的回文数的数量。
 * <p>
 * 输入
 * 第一行包含一个整数N, 1 ≤N≤1018。
 * <p>
 * 输出
 * 输出一个整数M，表示小于等于 N 的回文数的数量
 * <p>
 * <p>
 * 样例输入
 * 6
 * 样例输出
 * 4
 *
 * @author XIAO
 * @create 2017-09-28 16:50
 **/
public class HuiWenNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        long count = 0;
        for (long i = 0; i <= n; i++) {
            if (ishuiwen(i)) {
                count++;
            }
        }
        System.out.println(count);
    }

    /**
     * 判断一个数的二进制是否是回文的
     *
     * @param n
     * @return
     */
    public static boolean ishuiwen(long n) {
        StringBuilder builder = new StringBuilder();
        boolean flag = false;
        while (n > 0) {
            long temp = n % 2;
            builder.append(temp);
            n /= 2;
        }
        if (builder.toString().equals(builder.reverse().toString())) {
            flag = true;
        }
        return flag;
    }
}
