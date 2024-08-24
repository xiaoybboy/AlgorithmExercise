package com.codetop.slidewindow.variablewindow;

/**
 * 给你一个二进制数组 nums ，你需要从中删掉一个元素。
 * 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
 * 如果不存在这样的子数组，请返回 0 。
 */
public class LongestSubarray {

    public int longestSubarray(int[] nums) {
        int left = 0;
        //最长长度和窗口里0的个数
        int maxLength = 0, count = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                count++;
            }
            //当0的数量大于1的时候，就需要去移动左窗口了
            while (count > 1) {
                if (nums[left] == 0) {
                    count--;
                }
                left++;
            }
            //必须要删除一个1，所以是right-left
            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }
}
