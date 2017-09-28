package com.company;

import java.util.Scanner;

/**
 * @author XIAO
 * @create 2017-09-26 19:28
 **/
public class perfectWorld {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] fenshu = new int[n];//每道题的分数
        for (int i = 0; i < n; i++) {
            fenshu[i] = sc.nextInt();
        }

        int[] times = new int[n];//每道题耗费的时间
        for (int j = 0; j < n; j++) {
            times[j] = sc.nextInt();
        }

        int totaltime = sc.nextInt();
        int[][] res = BackPack_Solution(totaltime, n, fenshu, times);
        System.out.println(res[n][totaltime]);
    }

    public static int[][] BackPack_Solution(int m, int n, int[] w, int[] p) {
        // c[i][v]表示前i件物品恰放入一个重量为m的背包可以获得的最大价值
        int c[][] = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++)
            c[i][0] = 0;
        for (int j = 0; j < m + 1; j++)
            c[0][j] = 0;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                // 当物品为i件重量为j时，如果第i件的重量(w[i-1])小于重量j时，c[i][j]为下列两种情况之一：
                // (1)物品i不放入背包中，所以c[i][j]为c[i-1][j]的值
                // (2)物品i放入背包中，则背包剩余重量为j-w[i-1],所以c[i][j]为c[i-1][j-w[i-1]]的值加上当前物品i的价值
                if (w[i - 1] <= j) {// 物品i放入背包
                    c[i][j] = Math.max(c[i - 1][j], c[i - 1][j - w[i - 1]] + p[i - 1]);
                } else {
                    c[i][j] = c[i - 1][j];// 物品i不能放入背包w[i - 1] > j
                }
            }
        }
        return c;
    }
}
