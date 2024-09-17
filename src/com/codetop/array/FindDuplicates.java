package com.codetop.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个长度为 n 的整数数组 nums ，其中 nums 的所有整数都在范围 [1, n] 内，且每个整数出现 一次 或 两次 。
 * 请你找出所有出现 两次 的整数，并以数组形式返回。
 */
public class FindDuplicates {

    public static void main(String[] args) {
        int[] nums = {10, 2, 5, 10, 9, 1, 1, 4, 3, 7};
        findDuplicates2(nums);
    }

    //1.找到数字i时，将位置i-1处的数字翻转为负数。
    //2.如果位置i-1 上的数字已经为负，则i是出现两次的数字。
    //3.数组内数字都在[1-N]内，nums长度为n，利用nums作为索引
    //4.把数组中每个元素对应的数字，在数组中的位置对应的数字翻转为负数。如果某个元素已经为负数，说明这个数字已经存在。
    public static List<Integer> findDuplicates2(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int x : nums) {
            //这里绝对值，应为这个位置可能已经翻转为负数了
            int index = Math.abs(x) - 1;
            //如果这个位置为负数，说明这个值已经存在了
            if (nums[index] < 0) {
                ans.add(index + 1);
                continue;
            }
            nums[index] = -nums[index];
        }
        return ans;
    }
}
