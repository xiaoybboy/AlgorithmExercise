package com.company.qunar;

import java.util.Scanner;

/**
 * 自动驾驶技术这个词因Tesla为人们所熟悉，殊不知tesla仍只是处于非常初级辅助阶段，然而Uber与Volvo已经开始在匹兹堡试验部署真正意义的自动驾驶汽车，原理是在构建好的复杂地图数据基础上，
 * 
 * 根据在车辆移动时通过GPS结合车上的数个传感器、立体摄像头以及激光雷达收集数据与地图数据比对以此来识别交通标志、行人和障碍物并选择合适的道路自动讲乘客从A点带到B点。
 * 
 * 假设我们将地图抽象成一个N xN的二维矩阵，0为可行驶道路1为障碍物，车辆只能一步步按东、南、西、北方向行驶，
 * 
 * 请请输出从A点[0,0]至B点[n-1,n-1]的最少步数（移动一次计一步）。
 * 
 * 输入
 * 
 * 一共n行，每行n个整数（空格分隔），只可能为0或1
 * 
 * 样例输入
 * 
 * 0 1 0 0
 * 
 * 0 0 0 1
 * 
 * 1 0 1 0
 * 
 * 0 0 0 0
 * 
 * 输出
 * 
 * 输出最短路径，不可到达则输出nopath
 * 
 * @author XIAO
 *
 */
public class AutoPilot01 {
	private static int min = 0;
	private static int temp = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		while (sc.hasNext()) {
			String string = sc.nextLine();
			for (int i = 0; i < string.length(); i++) {
				char c = string.charAt(i);
				if (c != ' ') {
					count++;
				}
			}
			int[][] arr = new int[count][count];
			int k = 0;
			for (int i = 0; i < string.length(); i++) {
				char c = string.charAt(i);
				if (c != ' ') {
					arr[0][k] = Integer.parseInt(String.valueOf(c));
					k++;
				}
			}
			for (int i = 1; i < count; i++) {
				for (int j = 0; j < count; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			search(arr, 0, 0);
			if (min == 0) {
				System.out.println(-1);
			} else {
				System.out.println(min);
			}
		}
	}

	private static void search(int[][] arr, int row, int col) {
		if (row >= arr.length || col >= arr.length || row < 0 || col < 0) {
			return;
		}
		if (row == arr.length - 1 && col == arr.length - 1) {
			if (min == 0) {
				min = temp;
			} else {
				if (temp < min) {
					min = temp;
				}
			}
			return;
		}
		if (arr[row][col] == 0) {
			temp++;// 步数
			arr[row][col] = 1;// 回朔法，让当前变得不可达，免得后面的循环
			search(arr, row - 1, col);
			search(arr, row + 1, col);
			search(arr, row, col - 1);
			search(arr, row, col + 1);
			temp--;// 因为要回溯，回到arr[row][col]的上一个节点，所以temp--
			arr[row][col] = 0;// 回朔法
		}
	}
}
