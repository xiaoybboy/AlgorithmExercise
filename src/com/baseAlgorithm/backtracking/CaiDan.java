package com.baseAlgorithm.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Lily非常喜欢旅游，经常和他老婆自驾出游。但是Lily是一个非常讲求性价比的程序员，所以每次在外面吃饭的时候都要控制价格。
 * 今年国庆Lily和他老婆出游，Lily规定每顿饭的价格上限为n，他老婆想点k个菜，餐厅提供m个菜。请问，在不超过Lily价格上限的情况下，
 * 点k个菜有多少种点法（同一种菜只能点一份）。
 * <p>
 * 输入：
 * 1、第一行为价格上限n，想点菜的个数k，以及菜品个数m
 * 2、接下来m行，每行一个菜品价格
 * 3、以上输入均为正整数
 * <p>
 * 输出：
 * 1、输出为一行，代表点菜的方案数
 */
public class CaiDan {
    private static int num = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxprices = sc.nextInt();
        int k = sc.nextInt();
        int m = sc.nextInt();

        int[] price = new int[m];
        for (int i = 0; i < m; i++) {
            price[i] = sc.nextInt();
        }
        ArrayList<Integer> prices = new ArrayList<Integer>();
        for (int i = 0; i < price.length; i++) {
            prices.add(price[i]);
        }

        backtracking(maxprices, k, prices);
        System.out.println(num);
    }

    public static void backtracking(int maxprice, int k, List<Integer> price) {
        if (maxprice <= 0) {
            return;
        }
        if (k == 0) {
            num++;
            return;
        }
        for (int i = 0; i < price.size(); i++) {
            int temp = price.get(i);
            if (maxprice >= temp) {
                maxprice -= temp;
                price.remove(i);
                backtracking(maxprice, k - 1, price);
                maxprice += temp;
                price.add(i, temp);
            }
        }
    }

}
