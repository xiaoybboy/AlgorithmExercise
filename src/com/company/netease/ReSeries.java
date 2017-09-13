package com.company.netease;

import java.util.Scanner;

/**
 * 小易有一个长度为N的正整数数列A = {A[1], A[2], A[3]..., A[N]}。
 * 牛博士给小易出了一个难题:
 * 对数列A进行重新排列,使数列A满足所有的A[i] * A[i + 1](1 ≤ i ≤ N - 1)都是4的倍数。
 * 小易现在需要判断一个数列是否可以重排之后满足牛博士的要求。
 * <p>
 * 输入描述:
 * 输入的第一行为数列的个数t(1 ≤ t ≤ 10),
 * 接下来每两行描述一个数列A,第一行为数列长度n(1 ≤ n ≤ 10^5)
 * 第二行为n个正整数A[i](1 ≤ A[i] ≤ 10^9)
 * <p>
 * <p>
 * 输出描述:
 * 对于每个数列输出一行表示是否可以满足牛博士要求,如果可以输出Yes,否则输出No。
 * <p>
 * 输入例子1:
 * 2
 * 3
 * 1 10 100
 * 4
 * 1 2 3 4
 * <p>
 * 输出例子1:
 * Yes
 * No
 * <p>
 * 分类讨论下。
 * 显然，任意数和 4 的倍数相乘，其结果仍是 4 的倍数；
 * 显然，若存在任意数量 2 的倍数，两两之间乘起来就是 4 的倍数；
 * 如果存在一个数既不是 4 的倍数，也不是 2 的倍数（即因子里没有 2 ）：
 * 1.放在 2 的倍数旁边，一定不符合要求；
 * 2.放在 4 的倍数旁边，两两相乘一定是 4 的倍数。
 * 因此符合要求的排列一定是，
 * 所有 2 的倍数相邻排在一起，所有 4 的倍数和剩下的数相间排列，这些剩下的元素个数不能超过 4 的倍数的数量
 * ，不然所有 4 的倍数都被包起来了。
 *
 * @author XIAO
 * @create 2017-09-10 13:18
 **/
public class ReSeries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int t = sc.nextInt();
            for (int i = 0; i < t; i++) {
                int count2 = 0;//2的倍数的个数
                int count4 = 0;//4的倍数的个数

                int n = sc.nextInt();
                for (int j = 0; j < n; j++) {
                    int temp = sc.nextInt();
                    if (temp % 4 == 0) {
                        count4++;
                    } else if (temp % 2 == 0) {
                        count2++;
                    }
                }

                int other = n - count2 - count4;//既不是2的倍数也不是4的倍数的个数
                if (count4 >= other) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}
