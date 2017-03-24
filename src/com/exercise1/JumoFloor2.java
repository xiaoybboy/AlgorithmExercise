package com.exercise1;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 
 * 思路：同样：假设第一次跳 1 阶。那么还剩 n-1 阶。一共还剩f(n-1)种跳法。
 * 
 * 假设第一次跳 2 阶。那么还剩 n-2 阶。一共还剩f(n-2)种跳法。 。。。
 * 
 * 假设第一次跳 n-1 阶。那么还剩 1 阶。一共还剩f(1)种跳法。
 * 
 * 假设第一次跳 n 阶。一种跳法。
 * 
 * 所以：f(n) = f(n-1)+f(n-2)+...+1; 而且:f(n-1) = f(n-2) +...+1;
 * 
 * 所以f(n) = 2f(n-1)
 * 
 * @author XIAO
 *
 */
public class JumoFloor2 {
	public int JumpFloorSolution(int target) {
		if (target <= 0) {
			return 0;
		}
		if (target == 1) {
			return 1;
		}
		return JumpFloorSolution(target - 1) * 2;
	}
}
