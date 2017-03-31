package com.offer1;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 
 * 思路：假设第一次跳了一阶，那么还剩 n-1 阶，有f(n-1)中跳法。
 * 
 * 假设第一次跳了2阶，那么还剩 n-2 阶，有f(n-2)中跳法。
 * 
 * 所以，这是一个斐波那契数列。f(n) = f(n-1)+f(n-2)
 * 
 * @author XIAO
 *
 */
public class JumpFloor {
	public int JumpFloorSolution(int target) {
		if (target == 0) {
			return 0;
		}
		if (target == 1) {
			return 1;
		}
		if (target == 2) {
			return 2;
		}
		int f1 = 1;
		int f2 = 2;
		int cursum = 0;
		for (int i = 3; i <= target; i++) {
			cursum = f1 + f2;
			f1 = f2;
			f2 = cursum;
		}
		return cursum;
	}
}
