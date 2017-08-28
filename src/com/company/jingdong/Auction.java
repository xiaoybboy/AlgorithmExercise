package com.company.jingdong;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述
 * <p>
 * 公司最近新研发了一种产品，共生产了n件。有m个客户想购买此产品，第i个客户出价Vi元。为了确保公平，公司决定要以一个固定的价格出售产品。
 * 每一个出价不低于要价的客户将会得到产品，余下的将会被拒绝购买。请你找出能让公司利润最大化的售价。
 * <p>
 * 输入
 * <p>
 * 输入第一行二个整数n(1<=n<=1000),m(1<=m<=1000)，分别表示产品数和客户数。
 * 接下来第二行m个整数Vi(1<=Vi<=1000000)，分别表示第i个客户的出价。
 * <p>
 * 样例输入
 * <p>
 * 5 4
 * <p>
 * 2 8 10 7
 * <p>
 * 输出 输出一行一个整数，代表能够让公司利润最大化的售价。
 * <p>
 * 解法：
 * <p>
 * 首先我们发现，公司的最后定价一定是某个客户的出价。因为我们假设公司把产品定价为x，最后有k个客户会购买，假设这k个客户的编号为i1; i2; :;ik，
 * <p>
 * 我们有：vij>=x 1<=j<=k从而有x<=min(vi1; vi2; : vik)这时候，如果公司定价为min(vi1;
 * vi2;vik)，这k个客户一定会买，
 * <p>
 * 且总收入不会减少。于是我们可以把出价从大到小排序，v1>v2>...>vm，当公司把价格定为vi时，1到i的客户一定可以购买，
 * 注意到公司一共只有n个商品，此时的收入f(i)为：f(i) =vi*min(i,n)依次枚举所有可能的出价， 收入的最大值就可以求出来：ans=max
 * f(i)(1<=i<=m)
 *
 * @author XIAO
 */
public class Auction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();// 产品数
        int n = sc.nextInt();// 客户数

        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }
        Arrays.sort(prices);

        int max = 0;// 最大利润
        int index = 0;// 最大利润出价
        int low = Math.max(0, n - m);// 注意：当出价客户个数n>商品数m时，只能选择价格数组中的后n个数,否则(n-i)会大于m,并不是卖出的商品数
        for (int i = low; i < n; i++) {
            int temp = prices[i] * (n - i);
            if (temp >= max) {
                max = temp;
                index = prices[i];
            }
        }
        System.out.println(index);
        sc.close();
    }
}
