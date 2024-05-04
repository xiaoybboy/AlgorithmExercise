package com.codetop.doublePoint;

/**
 * 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
 */
public class LongestOnes {
    //问题等价于：P[right]−P[left−1]≤k;其中P[i]到下标i的前缀和
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        //lsum到左窗口的前缀和，rsum到右窗口的前缀和
        int left = 0, lsum = 0, rsum = 0;
        int ans = 0;
        for (int right = 0; right < n; right++) {
            rsum += 1 - nums[right];
            //计算左窗口
            while (lsum < rsum - k) {
                lsum += 1 - nums[left];
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
