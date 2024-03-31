package com.codetop.binarysearch;

/**
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 */
public class SearchRange {

    /**
     * 二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int p = -1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                p = mid;
                break;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if (p == -1) {
            return new int[]{-1, -1};
        } else {
            int a = p, b = p;
            while (a > 0 && nums[a - 1] == target) {
                a--;
            }
            while (b < nums.length - 1 && nums[b + 1] == target) {
                b++;
            }
            return new int[]{a, b};
        }
    }
}
