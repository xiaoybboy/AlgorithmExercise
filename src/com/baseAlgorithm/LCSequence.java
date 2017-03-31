package com.baseAlgorithm;

/**
 * 用动态规划的方法求解最长公共子序列的问题
 * 
 * @author XIAO
 *
 */
public class LCSequence {

	// 求解str1 和 str2 的最长公共子序列的长度
	// 求解str1 和 str2 的最长公共子序列
	public static int LCS(String str1, String str2) {

		int m = str1.length();
		int n = str2.length();

		// 因为包含0,所以最长公共子串的长度数组 长度+1
		int[][] c = new int[m + 1][n + 1];// 保存公共子序列的长度
		// b[i][j]记录c[i][j]是通过哪一个子问题的值求得的，以决定搜索的方向。
		int[][] b = new int[m + 1][n + 1];

		// 当str1,str2有一个长度为0时，最长公共子串的长度肯定也是0
		for (int row = 0; row <= m; row++)
			c[row][0] = 0;
		for (int column = 0; column <= n; column++)
			c[0][column] = 0;

		for (int i = 1; i <= m; i++)
			for (int j = 1; j <= n; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					c[i][j] = c[i - 1][j - 1] + 1;
					b[i][j] = 0;
				} else if (c[i][j - 1] > c[i - 1][j]) {
					c[i][j] = c[i][j - 1];
					b[i][j] = 1;
				} else {
					c[i][j] = c[i - 1][j];
					b[i][j] = -1;
				}
			}
		Display(b, str1, m, n);
		return c[m][n];
	}

	// 回溯的基本实现，打印最长公共子序列
	public static void Display(int[][] b, String str, int i, int j) {
		if (i == 0 || j == 0)
			return;

		// 从b的右下角开始，沿着箭头的方向前进
		if (b[i][j] == 0) {
			Display(b, str, i - 1, j - 1);
			System.out.println(str.charAt(i-1) + " ");
		} else if (b[i][j] == 1) {
			Display(b, str, i - 1, j);
		} else if (b[i][j] == -1) {
			Display(b, str, i, j - 1);
		}
	}

	public static void main(String[] args) {
		String str1 = "BDCABAF";
		String str2 = "ABCBDAF";
		int result = LCS(str1, str2);
		System.out.println(result);
	}
}
