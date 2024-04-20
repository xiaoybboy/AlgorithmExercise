package com.codetop.binarysearch;

public class SearchInRotateArray {

    /**
     * 二分搜索
     * 常规二分查找 [l, mid] 和 [mid + 1, r] 哪个部分是有序的，并根据有序的那个部分确定我们该如何改变二分查找的上下界，
     * 因为我们能够根据有序的那部分判断出 target 在不在这个部分：
     * 如果 [l, mid - 1] 是有序数组，且 target 的大小满足 [nums[l],nums[mid])，则我们应该将搜索范围缩小至 [l, mid - 1]，否则在 [mid + 1, r] 中寻找。
     * 如果 [mid, r] 是有序数组，且 target 的大小满足 (nums[mid+1],nums[r]]，则我们应该将搜索范围缩小至 [mid + 1, r]，否则在 [l, mid - 1] 中寻找。
     */
    public int searchTargetInRotateArray(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int n = nums.length, l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            //如果左边有序
            if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && target <= nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                //如果右边有序
                if (nums[mid] <= target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找旋转数组中的最小值-数组中不存在重复元素
     */
    public int findMinValueInRotateArray(int[] array) {
        int low = 0, high = array.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (array[mid] < array[high]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return array[low];
    }

    /**
     * 数组中可能存在重复元素
     */
    public int findMinValueInRotateArray2(int[] array) {
        int low = 0, high = array.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (array[mid] < array[high]) {
                high = mid;
            } else if (array[mid] > array[high]) {
                low = mid + 1;
            } else {
                high--;
            }
        }
        return array[low];
    }
}
