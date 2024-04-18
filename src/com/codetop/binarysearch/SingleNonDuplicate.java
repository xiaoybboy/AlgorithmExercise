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
     * 如果 mid 所在的 [偶数下标, 奇数下标] 的值相等，说明前面半段没有缺失的数，那么，缺失的数肯定在后半段，反之，则在前半段。
     * <p>
     * 这里要进行一些判断：
     * <p>
     * 如果 mid 本身是偶数，那么 mid + 1 就是奇数；
     * 如果 mid 本身是奇数，那么 mid - 1 就是偶数。
     *
     * @param nums
     * @return
     */
    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (mid % 2 == 0) {
                //偶数的时候，比较mid和mid+1
                if (nums[mid] == nums[mid + 1]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            } else {
                //奇数的情况，比较Mid和mid-1
                if (nums[mid] == nums[mid - 1]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
        }
        return nums[high];
    }
}
