package com.company.jingdong;

import java.util.Scanner;

/**
 * 有一楼梯共m级，刚开始时你在第一级，若每次只能跨上一级或者二级，要走上m级，共有多少走法？注：规定从一级到一级有0种走法。
 * 给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100。为了防止溢出，请返回结果Mod 1000000007的值。
 * <p>
 * 测试样例：
 * 3
 * 返回：2
 * <p>
 * 思路:从第n阶分析，第n阶的可能性为 第n-1的可能性+第n-1阶的可能性
 * 所以，f(n) = f(n-1)+f(n-1),斐波那契数列
 *
 * @author XIAO
 * @create 2017-09-06 16:33
 **/
public class Stairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 1) {
            System.out.println(1);
        } else if (n == 2) {
            System.out.println(2);
        } else if (n == 3) {
            System.out.println(2);
        } else if (n > 3) {
            int f1 = 1;
            int f2 = 2;
            int f3 = 0;
            for (int i = 4; i <= n; i++) {
                f3 = (f1 + f2) % 1000000007;
                f1 = f2;
                f2 = f3;
            }
            System.out.println(f3);
        }
    }
}
