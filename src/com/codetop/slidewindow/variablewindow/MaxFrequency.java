package com.codetop.slidewindow.variablewindow;

import java.util.Arrays;

/**
 * 元素的 频数 是该元素在一个数组中出现的次数。
 * 给你一个整数数组 nums 和一个整数 k 。在一步操作中，你可以选择 nums 的一个下标，并将该下标对应元素的值增加 1 。
 * 执行最多 k 次操作后，返回数组中最高频元素的 最大可能频数 。
 */
public class MaxFrequency {

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 1;
        int start = 0;
        long total = 0;
        for (int end = 1; end < nums.length; end++) {
            //计算区间内每个值，与区间内最后一个值相差的总和
            total += (nums[end] - nums[end - 1]) * (end - start);
            //如果超过目标值
            while (total > k) {
                //那么就减去区间内最左侧的值与最后一个值的差距。
                //然后再让区间左侧向右移动一位，相等于整个区间缩小了一位距离，在缩小的区间内再判断是否满足要求
                total -= nums[end] - nums[start];
                start++;
            }
            ans = Math.max(end - start + 1, ans);
        }
        return ans;
    }
}
