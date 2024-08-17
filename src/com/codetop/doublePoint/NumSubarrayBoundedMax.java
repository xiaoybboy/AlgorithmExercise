package com.codetop.doublePoint;

/**
 * 给你一个整数数组 nums 和两个整数：left 及 right 。找出 nums 中连续、非空且其中最大元素在范围 [left, right] 内的子数组，并返回满足条件的子数组的个数。
 * <p>
 * 生成的测试用例保证结果符合 32-bit 整数范围。
 */
public class NumSubarrayBoundedMax {

    /**
     * 区间内元素必须满足最大值在left-right之间
     * 对每个i，i1代表满足条件的左区间，i2代表满足条件的右区间
     * 当nums[i]>=left的时候更新i1
     * 当Nums[i]>right的时候更新i2
     */
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int ans = 0;
        int j = -1, k = -1;//j表示第一次满足nums[i]在left-right之间的位置;k表示最近一次nums[i]大于right的位置
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > right) {
                k = i;//num[i]>rigth,不可能存在以num[i]为子数组右边界，且满足条件的子数组
            } else {
                if (nums[i] < left) {
                    if (j > k) ans += j - k;//nums[i]不满足，需要其他元素满足
                } else {
                    ans += i - k;//nums[i]本身已经满足在left-right之间，只需要找到上一个>right位置，中间i-k的元素都是满足条件的子数组
                    j = i;//更新j
                }
            }
        }
        return ans;
    }
}
