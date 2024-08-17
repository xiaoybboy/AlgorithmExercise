package com.codetop.binarysearch;

/**
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
 * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 */
public class FindDuplicate {

    /**
     * 「二分查找」的思路是先猜一个数（搜索范围 [left..right] 里位于中间的数 mid），然后统计原始数组中 小于等于 mid 的元素的个数 count：
     * <p>
     * 如果 count 严格大于 mid。根据 抽屉原理，重复元素就在区间 [left..mid] 里；
     * 否则，重复元素可以在区间 [mid + 1..right] 里找到
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int left = -1, right = nums.length;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (checkBlue(nums, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    private boolean checkBlue(int[] nums, int target) {
        int count = 0;
        for (int x : nums) {
            if (x <= target) {
                count++;
                //小于等于target的数字>target，说明重复的数字一定在右侧
                if (count > target) {
                    return true;
                }
            }
        }
        return false;
    }
}
