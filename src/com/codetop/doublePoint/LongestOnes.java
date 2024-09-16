package com.codetop.doublePoint;

/**
 * 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
 */
public class LongestOnes {

    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;

        int left = 0, right = 0;
        int curZeroNum = 0;
        while (right < n) {
            if (nums[right] == 0) {
                curZeroNum++;
            }
            //移动左窗口，满足条件窗口内0的数量<=k
            while (curZeroNum > k) {
                if (nums[left] == 0) {
                    curZeroNum--;
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}
