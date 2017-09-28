package com.company.webank;

import java.util.Scanner;

/**
 * 题目描述：
 * 给出三个整数a，b，c，你需要计算数2a+2b-2c在二进制表示下1的个数。
 * <p>
 * 输入
 * 第一行包含三个整数a,b,c。1≤c＜b＜a≤109
 * <p>
 * 输出
 * 输出对应的答案。
 * 提示：2^3+2^2-2^1=10=(1010)2
 * <p>
 * 样例输入
 * 3 2 1
 * 样例输出
 * 2
 *
 * @author XIAO
 * @create 2017-09-28 16:19
 **/
public class OneNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();

        double res = Math.pow(2, a) + Math.pow(2, b) - Math.pow(2, c);
        long result = (long) res;
        int count = 0;
        if (result == 0) {
            count = 0;
        } else {
            while (result > 0) {
                long temp = result % 2;
                if (temp == 1) {
                    count++;
                }
                result /= 2;
            }
        }

        System.out.println(count);
    }
}
