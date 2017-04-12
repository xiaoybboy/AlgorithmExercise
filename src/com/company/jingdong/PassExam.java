package com.company.jingdong;

import java.util.Scanner;

/**
 * 小明同学要参加一场考试，考试一共有n道题目，小明必须做对至少60%的题目才能通过考试。考试结束后，
 * 小明估算出每题做对的概率，p1,p2,...,pn。你能帮他算出他通过考试的概率吗？
 * 
 * 输入
 * 输入第一行一个数n（1<=n<=100），表示题目的个数。第二行n个整数，p1,p2,...,pn。表示小明有pi%的概率做对第i题。（0<=pi<=100）
 * 
 * 样例输入
 * 
 * 4
 * 
 * 50 50 50 50
 * 
 * 输出 小明通过考试的概率，最后结果四舍五入，保留小数点后五位。
 * 
 * 思路：动态规划
 * 
 * dp[i][j]表示在第1;2;3; ; i道题目中，小明一共能答对j道题目的概率。
 * 
 * 显然dp[0][j] = 0(如果j!=0) dp[0][j]=0(如果j=0)
 * 
 * 就第i道题而言，有下面的等式成立。重复子问题.
 * 
 * dp[i][j] = dp[i-1][j-1]*pi + dp[i-1][j]*(1-pi)//前i-1道题答对j-1道，并且第i道题答对 +
 * 前i-1道题答对j道，并且第i道题答错
 * 
 * 此递推求出所有的f(i; j)，答案为： ans=∑f(n,i)(i=1--n)
 * 
 * @author XIAO
 *
 */
public class PassExam {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();// 题目数
		double[] p = new double[n];// 概率
		for (int i = 0; i < n; i++) {
			p[i] = (double) sc.nextInt() / 100;
			System.out.println(p[i]);
		}

		double[][] dp = new double[n + 1][n + 1];
		dp[0][0] = 1;// 上面分析

		for (int i = 1; i < n + 1; i++) {
			dp[0][i] = 0;// 0道题作对j道的概率都为0
		}

		// 第i道题
		for (int i = 1; i < n + 1; i++) {
			dp[i][0] = dp[i - 1][0] * (1 - p[i - 1]);// 前n道题作对0道的概率
			for (int j = 1; j < n + 1; j++) {
				dp[i][j] = dp[i - 1][j - 1] * p[i - 1] + dp[i - 1][j] * (1 - p[i - 1]);
			}
		}

		double result = 0.0;// 做对60%的概率
		for (int i = (int) Math.ceil(0.6 * n); i <= n; i++) {//向上取整
			result += dp[n][i];
		}
		//向上取整还可以(3*n+4)/5
		
		System.out.println(String.format("%.5f", result));// 结果格式化，保留5位小数
		sc.close();
	}

}
