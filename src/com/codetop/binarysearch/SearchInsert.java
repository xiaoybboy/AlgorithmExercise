package com.codetop.binarysearch;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 */
public class SearchInsert {

    public int searchInsert(int[] nums, int target) {
        int start = -1, end = nums.length;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (start < 0) {
            return 0;
        }
        if (nums[start] == target) {
            return start;
        }
        return start + 1;
    }
}
