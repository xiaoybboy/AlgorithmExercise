package com.codetop.binarysearch;

/**
 * 峰值元素是指其值严格大于左右相邻值的元素。
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 */
public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int left = -1, right = n - 1;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
