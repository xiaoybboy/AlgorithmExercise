package com.company.baidu;

import java.util.Scanner;

/**
 * 题目描述
 * <p>
 * 有一个分数序列 2/1,3/2,5/3,8/5,13/8,21/13,.... 求这个分数序列的前n项之和。
 * <p>
 * <p>
 * 输入 测试数据有多组，
 * <p>
 * 其第一行为一个正整数k(0＜k＜=90)，表示测试数据的组数。每组测试数据为一行，为单个正整数n（0＜n＜=90）。
 * <p>
 * 样例输入 1 2
 * <p>
 * 输出 每组测试数据单独输出有一行：分数序列的和（精确到小数点后4位）。
 * <p>
 * 样例输出 3.5000
 *
 * @author XIAO
 */
public class FractionsSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            double sum = 0.0;
            double a = 1.0, b = 2.0;
            for (int j = 0; j < n; j++) {
                double cur = b / a;
                b = a + b;
                a = b - a;
                sum += cur;
            }
            System.out.printf("%.4f", sum);
            System.out.println();
        }
    }
}
