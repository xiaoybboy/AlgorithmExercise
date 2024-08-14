package com.codetop.binarysearch;

public class SearchInRotateArray {

    int n = 0;
    public int search(int[] nums, int target) {
        n = nums.length;
        int left = -1, right = n;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (check(nums, mid, target)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[right] == target) {
            return right;
        }
        return -1;
    }

    //判断mid是否在target左侧
    private boolean check(int[] nums, int mid, int target) {
        int end = nums[n - 1];
        //如果target在左侧序列
        if (target > end) {
            //要求mid也必须在左侧，并且<target
            return nums[mid] > end && nums[mid] < target;
        } else {
            //要求mid在左侧序列，或者在右侧序列，小于target
            return nums[mid] > end || nums[mid] < target;
        }
    }
}
