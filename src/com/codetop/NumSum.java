package com.codetop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * N个数之和
 */
public class NumSum {

    //三个数之和
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int start = 0; start < n - 2; start++) {
            if (nums[start] > 0) {
                break;
            }
            //去除i的重复
            if (start > 0 && nums[start] == nums[start - 1]) {
                continue;
            }
            int mid = start + 1, end = n - 1;
            while (mid < end) {
                int sum = nums[start] + nums[mid] + nums[end];
                if (sum < 0) {
                    mid++;
                } else if (sum > 0) {
                    end--;
                } else {
                    result.add(Arrays.asList(nums[start], nums[mid], nums[end]));
                    while (mid < end && nums[mid + 1] == nums[mid]) {
                        mid++;
                    }
                    while (mid < end && nums[end - 1] == nums[end]) {
                        end--;
                    }
                    mid++;
                    end--;
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
