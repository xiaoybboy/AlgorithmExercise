package com.codetop.binarysearch;

/**
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 */
public class SearchRange {

    public static int[] searchRange(int[] nums, int target) {
        //1.划分蓝红边界，蓝色<target,红色>=target
        //2.返回值left
        int start = -1, end = nums.length;
        int n = nums.length;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {//checkBlue
                start = mid;
            } else {
                end = mid;
            }
        }
        //start = n-1说明所有数字都比target小
        if (start == n - 1) {
            return new int[]{-1, -1};
        } else {
            //<target的位置的数字，后一个数字不等于target，说明也不存在
            if (nums[start + 1] != target) {
                return new int[]{-1, -1};
            } else {
                int index = start + 1;
                while (index < n && nums[index] == target) {
                    index++;
                }
                return new int[]{start + 1, index - 1};
            }
        }
    }
}
