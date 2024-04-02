package com.codetop;

import java.util.Arrays;

/**
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * <p>
 * 返回这三个数的和。
 * <p>
 * 假定每组输入只存在恰好一个解。
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int resultSum = 0;
        //固定左边的元素
        for (int i = 0; i < n; i++) {
            int left = i + 1;//固定元素的下一个元素
            int right = n - 1;//右边的元素
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int abs = Math.abs(sum - target);
                if (abs < min) {
                    min = abs;
                    resultSum = sum;
                }
                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    return target;
                }
            }
        }
        return resultSum;
    }
}
