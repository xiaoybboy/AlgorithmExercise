package com.codetop.array;

/**
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 */
public class Rotate {

    /**
     * 首先对整个数组实行翻转，这样子原数组中需要翻转的子数组，就会跑到数组最前面。
     * 这时候，从 kkk 处分隔数组，左右两数组，各自进行翻转即可。
     */
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }

    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            //如果右侧有序，则最小值在左边
            if (nums[mid] < nums[end]) {
                end = mid;
            } else {
                start = mid+1;
            }
        }
        return nums[start];
    }
}
