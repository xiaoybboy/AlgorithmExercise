package com.codetop.greedy;

/**
 * 给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
 * <p>
 * 如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false
 */
public class IncreasingTriplet {

    /**
     * 用a表示长度为1的递增序列的最后一个元素能取得的最小的值
     * 用b表示长度为2的递增序列的最后一个元素能取得的最小值
     * 如果某个时刻 nums[i]>b那么就有3个了 遍历的同时不断更新a和b 关键是要让a和b尽可能的小!!!
     */
    public boolean increasingTriplet(int[] nums) {
        int a = nums[0], b = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            //找到大于b的数字，则找到了一个三元组
            if (nums[i] > b) {
                return true;
            }
            //更新a和b的值
            if (nums[i] > a) {
                b = Math.min(b, nums[i]);
            } else {
                a = nums[i];
            }
        }
        return false;
    }
}
