package com.codetop.binarysearch;

/**
 * 给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。
 * <p>
 * 请你找出并返回只出现一次的那个数。
 */
public class SingleNonDuplicate {

    /**
     * 题目说明了只有一个数只出现一次，那么，如果我们把这个数补齐到两个，比如，示例1补齐之后，可以得到 nums = [1,1,2,2,3,3,4,4,8,8]，
     * 可以发现，每一对 [偶数下标, 奇数下标] 的数肯定是相等的，因此，我们可以利用这条特性来进行二分查找。
     * <p>
     */
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int left = -1, right = n;
        // nums = [1,1,2,2,3,4,4,8,8]
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            //奇数下标
            if (mid % 2 == 1) {
                if (mid - 1 >= 0 && nums[mid] == nums[mid - 1]) {
                    left = mid;
                } else {
                    right = mid;
                }
            } else {
                //偶数下标
                if (mid + 1 < n && nums[mid] == nums[mid + 1]) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        return nums[right];
    }
}
