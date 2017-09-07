package com.company.meituan;

import java.util.Scanner;

/**
 * 在股市的交易日中，假设最多可进行两次买卖(即买和卖的次数均小于等于2)，规则是必须一笔成交后进行另一笔(即买-卖-买-卖的顺序进行)。给出一天中的股票变化序列，请写一个程序计算一天可以获得的最大收益。请采用实践复杂度低的方法实现。
 * 给定价格序列prices及它的长度n，请返回最大收益。保证长度小于等于500。
 * <p>
 * 测试样例：
 * [10,22,5,75,65,80],6
 * 返回：87
 *
 * @author XIAO
 * @create 2017-09-07 13:56
 **/
public class StockDeal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < prices.length; i++) {
            prices[i] = sc.nextInt();
        }
        //如果只买卖一次
        int maxprofile1 = getProfile(prices, 0, prices.length - 1);
        //买卖两次
        int maxProfile2 = getMaxProfile(prices);
        System.out.println(Math.max(maxprofile1, maxProfile2));
    }

    //根据左半部分的最大收益和右半部分的最大收益来计算全局的最大收益
    private static int getMaxProfile(int[] prices) {
        int maxProfile = 0;
        //如果i=0.或者i=prices.length-1,说明只进行一次买卖
        for (int i = 1; i < prices.length - 1; i++) {
            int leftMaxProfile = getProfile(prices, 0, i);
            int rightMaxProfile = getProfile(prices, i + 1, prices.length - 1);
            if (leftMaxProfile + rightMaxProfile > maxProfile) {
                maxProfile = leftMaxProfile + rightMaxProfile;
            }
        }
        return maxProfile;
    }

    //局部最大收益
    private static int getProfile(int[] prices, int start, int end) {
        int max = 0;
        int minPrice = prices[start];
        for (int j = start; j <= end; j++) {
            if (prices[j] < minPrice) {
                minPrice = prices[j];
            }
            if (prices[j] - minPrice > max) {
                max = prices[j] - minPrice;
            }
        }
        return max;
    }
}
