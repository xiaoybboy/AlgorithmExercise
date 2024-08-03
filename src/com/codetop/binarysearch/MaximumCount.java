package com.codetop.binarysearch;

/**
 * 给你一个按 非递减顺序 排列的数组 nums ，返回正整数数目和负整数数目中的最大值。
 * <p>
 * 换句话讲，如果 nums 中正整数的数目是 pos ，而负整数的数目是 neg ，返回 pos 和 neg二者中的最大值。
 * 注意：0 既不是正整数也不是负整数。
 */
public class MaximumCount {

    public int maximumCount(int[] nums) {
        int start = 0, end = nums.length;
        int zeroIndex = -1;
        while (start < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] == 0) {
                zeroIndex = mid;
                break;
            } else if (nums[mid] < 0) {

            }
        }
        return -1;
    }
}
