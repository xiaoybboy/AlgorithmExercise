package com.codetop.binarysearch;

import java.util.Arrays;

/**
 * 给你一个长度为 n 的整数数组 nums ，和一个长度为 m 的整数数组 queries 。
 * <p>
 * 返回一个长度为 m 的数组 answer ，其中 answer[i] 是 nums 中 元素之和小于等于 queries[i] 的 子序列 的 最大 长度  。
 * <p>
 * 子序列 是由一个数组删除某些元素（也可以不删除）但不改变剩余元素顺序得到的一个数组。
 */
public class AnswerQueries {

    /**
     * 元素的顺序对结果没有影响
     */
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length, m = queries.length;
        //排序之后求前缀和
        int[] f = new int[n + 1];
        for (int i = 0; i < nums.length; i++) {
            f[i + 1] = f[i] + nums[i];
        }

        int[] ans = new int[m];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = binarySearch(f, queries[i]) - 1;
        }
        return ans;
    }

    /**
     * 找到大于target最小的位置
     *
     * @param nums
     * @param target
     * @return
     */
    private int binarySearch(int[] nums, int target) {
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
