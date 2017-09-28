package com.company.webank;

import java.util.Scanner;

/**
 * 题目描述：
 * 给出一个非负整数 n，我们可以用各种进制来表示它。比如说数 23，它在十进制表示下就是 23，在二进制表示下是 10111，在八进制表示下是 27，
 * 在十二进制表示下 1B(B 表示 11)。 n在某种进制表示下的权值为将其各位数字相加的和，比如 23 在二进制表示下的权值为1+0+1+1+1=4，23
 * 在八进制表示下的权值为 2+7=9，23 在十二进制表示下的权值为1+11=12。
 * <p>
 * 现在给出一个非负整数n，你可以用p进制去表示它(2 ≤p≤n )，同时你要使得它在这种进制表示下的权值最大。
 * <p>
 * 输入
 * 第一行包含一个整数n  , 2 ≤n ≤ 109
 * <p>
 * 输出
 * 输出最大的权值。
 * <p>
 * 样例输入
 * 23
 * 样例输出
 * 12
 *
 * @author XIAO
 * @create 2017-09-28 16:43
 **/
public class MaxWeightDiffHex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        long maxSum = 0;
        for (long i = 2; i <= n/2; i++) {
            long tempSum = getSum(n, i);
            if (tempSum > maxSum) {
                maxSum = tempSum;
            }
        }
        System.out.println(maxSum);
    }

    /**
     * 不同进制下的n的权重和
     *
     * @param n
     * @param hex
     * @return
     */
    public static long getSum(long n, long hex) {
        long sum = 0;
        while (n > 0) {
            long temp = n % hex;
            sum += temp;
            n = n / hex;
        }
        return sum;
    }
}
