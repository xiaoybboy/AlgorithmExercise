package com.codetop.binarysearch;

public class SearchInRotateArray {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1, 2, 1, 1, 1};
        search(nums, 2);
    }

    public static int search(int[] nums, int target) {
        int n = nums.length;
        int left = -1, right = nums.length;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            int cur = nums[mid];
            if (cur == target) {
                return mid;
            }
            //左侧
            if (target > nums[n - 1]) {
                if (cur > nums[n - 1] && cur < target) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
            //右侧
            else if (target <= nums[n - 1]) {
                if (cur <= nums[n - 1] && cur <= target) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        if (nums[right] == target) {
            return right;
        }
        return -1;
    }
}
