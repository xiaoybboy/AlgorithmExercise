package com.codetop.monotonicstack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，
 * 并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j] 。
 * 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。
 */
public class Find132pattern {

    public static void main(String[] args) {
        int[] nums = {3, 5, 0, 3, 4};
        find132pattern(nums);
    }

    public static boolean find132pattern(int[] nums) {
        //贪心思想，我们总是希望3是最大值，2是比3小一点的最大值，1尽可能小
        //deque从栈底到栈顶，是单调递减的
        Deque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        int numj = Integer.MIN_VALUE;//记录最大的2的值
        for (int i = n - 1; i >= 0; i--) {
            //如果nums[i] < last2，说明找到了一个满足条件的1
            if (nums[i] < numj) {
                return true;
            }
            //总是希望numk尽可能的大，而numj是k右边小于numk的最大值
            //考虑57896的情况，当栈顶元素为9的时候，然后遇到8和7，就没必要更新numj了
            while (!deque.isEmpty() && nums[i] > deque.peek()) {
                numj = deque.pop();
            }
            deque.push(nums[i]);
        }
        return false;
    }
}
