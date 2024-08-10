package com.codetop.binarysearch;

public class SearchInRotateArray {

    /**
     * 二分搜索
     * 常规二分查找 [l, mid] 和 [mid + 1, r] 哪个部分是有序的，并根据有序的那个部分确定我们该如何改变二分查找的上下界，
     * 因为我们能够根据有序的那部分判断出 target 在不在这个部分：
     * 如果 [l, mid - 1] 是有序数组，且 target 的大小满足 [nums[l],nums[mid])，则我们应该将搜索范围缩小至 [l, mid - 1]，否则在 [mid + 1, r] 中寻找。
     * 如果 [mid, r] 是有序数组，且 target 的大小满足 (nums[mid+1],nums[r]]，则我们应该将搜索范围缩小至 [mid + 1, r]，否则在 [l, mid - 1] 中寻找。
     */
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = -1, r = n;
        while (l + 1 < r) {
            int c = l + (r - l) / 2;
            if (isBlue(nums, c, target)) {
                r = c;
            } else {
                l = c;
            }
        }
        if (r == n || nums[r] != target) return -1;
        return r;
    }

    // 以target为参照；蓝色：mid在target左侧;红色：mid在target右侧
    private boolean isBlue(int[] nums, int c, int target) {
        int n = nums.length;
        int end = nums[n - 1];
        if (target > end) {
            return nums[c] > end && nums[c] < target;
        }
        return nums[c] > end || nums[c] < target;
    }
}
