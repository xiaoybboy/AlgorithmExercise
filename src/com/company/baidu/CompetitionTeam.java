package com.company.baidu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 为活跃公司文化，公司计划组织一场比赛，让员工一展才艺。现有n个员工，欲选出不少于k人组成一支队伍，1＜=n＜ =12,1＜=k＜=n。
 * 每个员工有个value值，表示其对队伍水平的贡献，-1000＜=value＜=1000，给出一个矩阵对角线为0的对称矩阵A，
 * A[i][j]表示i,j同在队伍中时对队伍水平的贡献，为取得最好成绩，公司领导希望知道水平最高的组队方式能够达到的水平和组队方案数。
 * 
 * 
 * 输入
 * 
 * 第一行为测试样例组数Te（Te＜=100）。
 * 
 * 每组测试样例的第一行是两个数 n,k，
 * 
 * 第二行为n个数，表示每个人对队伍水平的贡献值，
 * 
 * 接下来有n行，每行有n个数，表示构成矩阵A的元素。
 * 
 * 样例输入
 * 
 * 1
 * 
 * 2 1
 * 
 * 100 -5
 * 
 * 0 10
 * 
 * 10 0
 * 
 * 输出 每组测试样例输出一行，分别为能够达到的最高水平值和组队方案数。
 * 
 * 样例输出 105 1
 * 
 * @author XIAO
 *
 */
public class CompetitionTeam {
	public static int max = 0, maxCount = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int Te = sc.nextInt();
		int res[][] = new int[2][Te];
		for (int t = 0; t < Te; t++) {
			max = Integer.MIN_VALUE;
			maxCount = 0;
			int n = sc.nextInt();
			int k = sc.nextInt();
			int values[] = new int[n];
			int A[][] = new int[n][n];
			for (int i = 0; i < n; i++)
				values[i] = sc.nextInt();
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					A[i][j] = sc.nextInt();
			justDo(values, A, new boolean[n], 0, 0, n, 0, k);
			res[0][t] = max;
			res[1][t] = maxCount;
		}
		for (int t = 0; t < Te; t++) {
			System.out.println(res[0][t] + " " + res[1][t]);
		}
		sc.close();
	}

	public static void justDo(int values[], int A[][], boolean flags[], int deep, int res, int n, int nowK, int k) {
		if (deep >= n) {
			if (nowK >= k) {
				if (res > max) {
					max = res;
					maxCount = 1;
				} else if (res == max) {
					maxCount++;
				}
			}
			return;
		}
		justDo(values, A, flags, deep + 1, res, n, nowK, k);
		boolean[] newFlags = Arrays.copyOf(flags, flags.length);
		newFlags[deep] = true;
		int res_tmp = res + values[deep];
		for (int i = 0; i < deep; i++) {
			if (flags[i])
				res_tmp += A[i][deep];
		}
		justDo(values, A, newFlags, deep + 1, res_tmp, n, nowK + 1, k);
	}

}
