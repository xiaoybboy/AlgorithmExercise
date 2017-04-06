package com.company.meituan;

/**
 * 在4x4的棋盘上摆满了黑白棋子，黑白两色的位置和数目随机其中左上角坐标为(1,1),右下角坐标为(4,4),
 * 
 * 现在依次有一些翻转操作，要对一些给定支点坐标为中心的上下左右四个棋子的颜色进行翻转，请计算出翻转后的棋盘颜色。
 * 给定两个数组A和f,分别为初始棋盘和翻转位置。其中翻转位置共有3个。请返回翻转后的棋盘。
 * 
 * @author XIAO
 *
 */
public class ReverseColor {
	public static int[][] flipChess(int[][] A, int[][] f) {
		for (int i = 0; i < f.length; i++) {
			// 第i个支点所在的行数和列数
			int row = f[i][0] - 1;
			int column = f[i][1] - 1;

			// 思路：当考虑行有上一行时，给上一行的i列的棋子赋值。同样，考虑有下一行的时候，给下一行i列棋子赋值。列同样。
			if (row - 1 >= 0) {// 不是第1行
				A[row - 1][column] = (A[row - 1][column] == 0) ? 1 : 0;// 给支点上面的棋子反转赋值
			}
			if (row + 1 < 4) {// 不是第四行(索引为3)
				A[row + 1][column] = (A[row + 1][column] == 0) ? 1 : 0;// 给支点上方的棋子反转赋值
			}

			if (column - 1 >= 0) {// 不是第1列
				A[row][column - 1] = (A[row][column - 1] == 0) ? 1 : 0;// 给支点左面的棋子反转赋值
			}
			if (column + 1 < 4) {// 不是第四列(索引为3)
				A[row][column + 1] = (A[row][column + 1] == 0) ? 1 : 0;// 给支点右方的棋子反转赋值
			}

		}
		return A;
	}

}
