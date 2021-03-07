package com.sort.dynamic;

import java.util.Scanner;

/**
 * 01b背包问题
 */
public class ZeroOnePackage {

    // N表示物体的个数，V表示背包的载重
    int N, V;
    //用于存储每个物体的重量，下标从1开始
    private int[] weight;
    //存储每个物体的收益，下标从1开始
    private int[] value;
    //二维数组，用来保存每种状态下的最大收益
    private int[][] F;

    /**
     * 输入格式：
     * 5 10
     * 2 2 6 5 4
     * 6 3 5 4 6
     * result:15
     * 第一行是物体个数、背包总空间；
     * 第二行是每个物体的空间；
     * 第三行是每个物体的收益。
     */
    public void init() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();//
        V = sc.nextInt();

        weight = new int[N + 1];
        value = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            weight[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }

        F = new int[N + 1][V + 1];
        //把前i个物品放入容量为0的背包，价值为0
        for (int i = 0; i <= N; i++) {
            F[i][0] = 0;
        }

        //把前0个物品放入容量为j的背包中，价值为0
        for (int j = 0; j <= V; j++) {
            F[0][j] = 0;
        }
    }

    /**
     * @return
     */
    public void knapsack() {
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < V + 1; j++) {
                //如果放不下
                if (weight[i] > j) {
                    F[i][j] = F[i - 1][j];
                } else {
                    F[i][j] = Math.max(F[i - 1][j], F[i - 1][j - weight[i]] + value[i]);
                }
            }
        }

        //打印所有结果，我们要求的是F[N][V]
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= V; j++) {
                System.out.print(F[i][j] + " ");
            }
            System.out.println();
        }
    }


    /**
     * 求解F[n][m]这个最优值具体选取哪几样物品能获得最大价值，但只会输出一种情况
     *
     * @param n 表示前n个物体，n <= N
     * @param v 表示背包的容量，v <= V
     */
    public void printResult(int n, int v) {
        boolean[] isAdd = new boolean[n + 1];

        for (int i = n; i >= 1; i--) {
            if (F[i][v] == F[i - 1][v])
                isAdd[i] = false;
            else {
                isAdd[i] = true;
                v -= weight[i];
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(isAdd[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ZeroOnePackage zeroOnePackage = new ZeroOnePackage();
        zeroOnePackage.init();
        zeroOnePackage.knapsack();
        zeroOnePackage.printResult(zeroOnePackage.N, zeroOnePackage.V);
    }
}
