package com.company.netease;

import java.util.Scanner;

/**
 * <p>Fibonacci数列是这样定义的：
 * F[0] = 0
 * F[1] = 1
 * for each i ≥ 2: F[i] = F[i-1] + F[i-2]
 * 因此，Fibonacci数列就形如：0, 1, 1, 2, 3, 5, 8, 13, ...，在Fibonacci数列中的数我们称为Fibonacci数。给你一个N，
 * 你想让其变为一个Fibonacci数，每一步你可以把当前数字X变为X-1或者X+1，现在给你一个数N求最少需要多少步可以变为Fibonacci数。
 * </p>
 * 输入描述:
 * 输入为一个正整数N(1 ≤ N ≤ 1,000,000)
 * <p>
 * <p>
 * 输出描述:
 * 输出一个最小的步数变为Fibonacci数"
 * <p>
 * 输入例子:
 * 15
 * <p>
 * 输出例子:
 * 2</p>
 *
 * @author XIAO
 * @since 2017/8
 */
public class FibonacciNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int n1 = 0;
        int n2 = 1;
        int curNum = 1;

        //找到比N大的第一个斐波那契数
        while (curNum < N) {
            n1 = n2;
            n2 = curNum;
            curNum = n1 + n2;
        }

        int preNum = n2;//比N小的上一个数
        System.out.println(Math.min(Math.abs(N - preNum), Math.abs(curNum - N)));
    }
}
