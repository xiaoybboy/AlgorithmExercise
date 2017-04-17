package com.company.ctrip;

import java.util.Scanner;

/**
 * 拼图，是一个老少皆宜的益智游戏，在打乱的3*3的范围中，玩家只能每次将空格(0)和相邻的数字格（上、下、左、右）交换，
 * 
 * 最终调整出一个完整的拼图。
 * 
 * 完整拼图为：
 * 
 * 1 2 3
 * 
 * 4 5 6
 * 
 * 7 8 0
 * 
 * 输入
 * 
 * 测试数据共3行，每行3个数字 ，包括数字0、1、2、3.....8（无重复）
 * 
 * 样例输入
 * 
 * 0 1 3
 * 
 * 4 2 5
 * 
 * 7 8 6
 * 
 * 输出
 * 
 * 还原完整拼图的最少移动次数。如不需要调整，则输出0；如无解，则输出-1。
 * 
 * @author XIAO
 *
 */
public class Jigsaw {

	static int[] f = new int[10];
	static int[] finals = new int[360000];
	static int[][] d = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static boolean[] vis = new boolean[368805];
	// typedef int State[9];
	static int[][] midst = new int[364000][9];
	static int[] initstate = new int[9];

	// State midst[364000],initstate;
	static void ini() {
		f[0] = 1;
		for (int i = 1; i < 9; i++)
			f[i] = f[i - 1] * i;
	}

	static boolean visited(int x) {
		int code = 0;
		for (int i = 0; i < 9; i++) {
			int cnt = 0;
			for (int j = i + 1; j < 9; j++)
				if (midst[x][i] > midst[x][j])
					cnt++;
			code += cnt * f[8 - i];
		}
		if (vis[code])
			return false;
		vis[code] = true;
		return true;
	}

	static boolean memcmp(int[] src, int[] dst, int n) {
		for (int i = 0; i < n; ++i) {
			if (src[i] != dst[i])
				return true;
		}
		return false;
	}

	static int bfs() {
		ini();
		int head = 1, end = 2;
		finals[head] = 0;
		while (head < end) {
			// State &a=midst[head];
			int[] a = midst[head];
			if (!memcmp(initstate, a, a.length))
				return head;
			int z;
			for (z = 0; z < 9; z++)
				if (a[z] == 0)
					break;
			int x = z / 3, y = z % 3;
			for (int i = 0; i < 4; i++) {
				int newx = x + d[i][0], newy = y + d[i][1];
				int newz = newx * 3 + newy;
				if (newx >= 0 && newx < 3 && newy < 3 && newy >= 0) {
					int[] t = midst[end];
					// memcpy(&t,&a,sizeof(a));
					for (int j = 0; j < a.length; ++j) {
						t[j] = a[j];
					}
					int temp = t[z];
					t[z] = t[newz];
					t[newz] = temp;
					// swap(t[newz],t[z]);
					finals[end] = finals[head] + 1;
					if (visited(end))
						end++;
				}
			}
			head++;
		}
		return 0;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int i;
		for (i = 0; i < 9; i++)
			initstate[i] = input.nextInt();
		midst[1][0] = 1;
		midst[1][1] = 2;
		midst[1][2] = 3;
		midst[1][3] = 4;
		midst[1][4] = 5;
		midst[1][5] = 6;
		midst[1][6] = 7;
		midst[1][7] = 8;
		midst[1][8] = 0;
		int result = bfs();
		if (result == 0)
			System.out.println("-1");
		else
			System.out.println(finals[result]);
		// return 0;
	}
}
