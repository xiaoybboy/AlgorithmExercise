package com.exercise1;

/**
 * 输出斐波那契数列的第n项
 * 
 * @author XIAO
 *
 */
public class Fibonacci {
	public int FibonacciSolution(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		int f1 = 0;
		int f2 = 1;
		int cursum = 0;
		for (int i = 2; i <= n; i++) {
			cursum = f1 + f2;
			f1 = f2;
			f2 = cursum;
		}
		return cursum;
	}
}
