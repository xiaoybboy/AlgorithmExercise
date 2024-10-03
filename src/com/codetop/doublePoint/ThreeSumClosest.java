package com.codetop.doublePoint;

import java.util.Arrays;

/**
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * 返回这三个数的和。
 * 假定每组输入只存在恰好一个解。
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int resultSum = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = n - 1;
            while (left < right) {
                int curSum = nums[i] + nums[left] + nums[right];
                int dis = Math.abs(curSum - target);
                //更新结果
                if (dis < min) {
                    min = dis;
                    resultSum = curSum;
                }
                //移动指针
                if (curSum < target) {
                    left++;
                } else if (curSum > target) {
                    right--;
                } else {
                    return target;
                }
            }
        }
        return resultSum;
    }
}
