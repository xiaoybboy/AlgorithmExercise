package com.codetop.binarysearch;

import java.util.Arrays;

/**
 * 给你一个下标从 0 开始、长度为 n 的整数数组 nums ，和两个整数 lower 和 upper ，返回 公平数对的数目 。
 * <p>
 * 如果 (i, j) 数对满足以下情况，则认为它是一个 公平数对 ：
 * <p>
 * 0 <= i < j < n，且
 * lower <= nums[i] + nums[j] <= upper
 */
public class CountFairPairs {

    public static void main(String[] args) {
        int[] nums = {0, 1, 7, 4, 4, 5};
        countFairPairs(nums, 3, 6);
    }

    static int n = 0;

    //题目可知，i和j的位置并不影响最终的结果，所以可以先排序
    //固定i，然后从>i的位置寻找满足条件的结果
    //nums[j]>=lower-nums[i]
    //nums[j]<=upper-nums[i]
    public static long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        n = nums.length;
        long result = 0;
        for (int i = 0; i < n; i++) {
            int lowerBound = searchLowerBound(nums, lower, i);
            //都不满足条件，即没有j，满足 nums[i] + nums[j]>=lower
            if (lowerBound == n) {
                continue;
            }
            int upperBound = searchUpperBound(nums, upper, i);
            //都不满足条件，即没有j，满足 nums[i] + nums[j]<=upper
            if (lowerBound == i) {
                continue;
            }
            result += (upperBound - lowerBound + 1);
        }
        return result;
    }

    //查找大于等于lower - nums[start]的第一个元素
    private static int searchLowerBound(int[] nums, int lower, int start) {
        int left = start, right = n;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < lower - nums[start]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }

    //查找小于等于upper-nums[i]的第一个元素
    private static int searchUpperBound(int[] nums, int upper, int start) {
        int left = start, right = n;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > upper - nums[start]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left;
    }
}
