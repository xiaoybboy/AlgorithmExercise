package com.codetop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * N个数之和
 */
public class NumSum {


    /**
     * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]]
     * 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
     * <p>
     * 你返回所有和为 0 且不重复的三元组。
     * 双指针法
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        int length = nums.length;
        //k < nums.length - 2是为了保证后面还能存在两个数字
        for (int k = 0; k < length - 2; k++) {
            if (nums[k] > 0) {
                break;
            }
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            int i = k + 1, j = length - 1;
            while (i < j) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    i++;
                } else if (sum > 0) {
                    j--;
                } else {
                    result.add(new ArrayList<>(Arrays.asList(nums[k], nums[i], nums[j])));
                    //左指针前进并去重
                    while (i < j && nums[i] == nums[i + 1]) {
                        i++;
                    }
                    //右指针后退并去重
                    while (i < j && nums[j] == nums[j - 1]) {
                        j--;
                    }
                    i++;
                    j--;
                }
            }
        }
        return result;
    }

    /**
     * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
     * <p>
     * 返回这三个数的和。
     */
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

    /**
     * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。
     * 请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = n - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
