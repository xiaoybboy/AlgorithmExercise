package com.company.netease;

import java.util.Scanner;

/**
 * 小易有n块砖块，每一块砖块有一个高度。小易希望利用这些砖块堆砌两座相同高度的塔。为了让问题简单，砖块堆砌就是简单的高度相加，
 * 某一块砖只能使用在一座塔中一次。小易现在让能够堆砌出来的两座塔的高度尽量高，小易能否完成呢。
 * <p>
 * <p>
 * 输入包括两行： 第一行为整数n(1 ≤ n ≤ 50)，即一共有n块砖块 第二行为n个整数，表示每一块砖块的高度height[i] (1 ≤
 * height[i] ≤ 500000)
 * <p>
 * <p>
 * 输出描述: 如果小易能堆砌出两座高度相同的塔，输出最高能拼凑的高度，如果不能则输出-1. 保证答案不大于500000。
 * <p>
 * /*假设砖块分为A，B两堆，dp[i][j]中的j表示B-A的长度。
 * 因为B-A有可能是负的，所以j整体偏移sum个长度，即2*sum+1。
 * 而dp[i][j]的值则表示当A-B的值为j时，B的最大长度是多少。
 * dp[i][j] = dp[i-1][j]表示我不用第i块砖 dp[i][j] =max(dp[i-1][j-h], dp[i-1][j])表示我把砖放在A堆。
 * dp[i][j] = max(dp[i-1][j+h]+h,dp[i-1][j])表示我把砖放在B堆。
 * 然后会爆内存，所以用了滚动数组。
 *
 * @author XIAO
 */
public class Brick {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] value = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            value[i] = in.nextInt();
            sum += value[i];
        }
        int[] dp0 = new int[sum * 2 + 1], dp1 = new int[sum * 2 + 1];
        /*
         * i=0时，需要dp[-1][j]的状态，也就是不用任何硬币，sumA=0,sumB=0，sumA-sumB=0,故dp0[0+sum]=
		 * sumB=0 其他sumA-sumB的情况是不能凑到的，比如dp[0][-1+sum]，sumB若取了0代表sumA=-1，这是不科学的。
		 * 所以其他情况均赋值-1。 dp1不需要赋值-1是因为在循环中会先给dp1[j]赋值dp0[j]的值。
		 */
        for (int i = 0; i < dp0.length; i++)
            dp0[i] = -1;
        dp0[sum] = 0;
        for (int i = 1; i <= n; i++) {
            int v = value[i - 1];
            for (int j = 0; j < 2 * sum + 1; j++) {
                dp1[j] = dp0[j];
                if (j - v >= 0 && dp0[j - v] != -1) {
                    dp1[j] = Math.max(dp0[j - v], dp1[j]);
                }
                if (j + v <= 2 * sum && dp0[j + v] != -1) {
                    dp1[j] = Math.max(dp0[j + v] + v, dp1[j]);
                }
            }
            // 交换dp，让dp0始终代表dp[i-1][j]的状态。
            int[] temp = dp1;
            dp1 = dp0;
            dp0 = temp;
        }
        // 因为最后会再将dp1交换到dp0上，所以输出时使用dp0。如果最后dp0[sum]=0的话，说明sumB=0，即没法凑到，则输出-1
        if (dp0[sum] == 0)
            System.out.println(-1);
        else
            System.out.println(dp0[sum]);
    }
}
