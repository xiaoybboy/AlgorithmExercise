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
    public int numSubarrayBoundedMax2(int[] nums, int left, int right) {
        int n = nums.length;
        int ans = 0;
        //overRightIndex表示上一个大于right的下标，mathIndex表示上一个满足条件的下标
        int overRightIndex = -1, mathIndex = -1;
        for (int i = 0; i < n; i++) {
            int curNum = nums[i];
            if (curNum > right) {
                //记录元素值大于right的下标
                overRightIndex = i;
                continue;
            } else if (curNum < left) {
                //小于left的时候，需要左边的元素来满足最大值在left-right之间
                if (curNum < left) {
                    if (mathIndex > overRightIndex) {
                        ans += mathIndex - overRightIndex;
                    }
                }
            } else {
                //nums[i]本身已经满足在left-right之间，只需要找到上一个>right位置，中间i-k的元素都是满足条件的子数组
                ans += i - overRightIndex;
                mathIndex = i;
            }
        }
        return ans;
    }
}
