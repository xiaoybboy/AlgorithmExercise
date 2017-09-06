package com.company.didi;

import java.util.Scanner;

/**
 * 输入一个正整数n,求n!(即阶乘)末尾有多少个0？ 比如: n = 10; n! = 3628800,所以答案为2
 * <p>
 * 思路:只有2*5的时候可以产生零，而5的个数比2的少，所以求5的个数就是零的个数。
 *
 * @author XIAO
 * @create 2017-09-06 16:26
 **/
public class ZeroCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 0;

        for (int i = n; i >= 5; i--) {
            int tmp = i;
            //计算有多少个5，例如25=5*5，两个5.
            while (tmp % 5 == 0) {
                res++;
                tmp /= 5;
            }
        }
        System.out.println(res);
    }
}
