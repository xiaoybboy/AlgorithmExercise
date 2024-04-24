package com.codetop.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个长度为 n 的整数数组 nums ，其中 nums 的所有整数都在范围 [1, n] 内，且每个整数出现 一次 或 两次 。
 * 请你找出所有出现 两次 的整数，并以数组形式返回。
 */
public class FindDuplicates {
    //1.找到数字i时，将位置i-1处的数字翻转为负数。
    //2.如果位置i-1 上的数字已经为负，则i是出现两次的数字。
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            //这里绝对值，应为这个位置可能已经翻转为负数了
            int index = Math.abs(nums[i]) - 1;
            //如果这个位置为负数，说明这个值已经存在了
            if (nums[index] < 0) {
                result.add(Math.abs(index + 1));
            }
            nums[index] = -nums[index];
        }
        return result;
    }
}
