package com.codetop.doublePoint;

/**
 * 给定一个非负整数数组 nums，  nums 中一半整数是 奇数 ，一半整数是 偶数 。
 * 对数组进行排序，以便当 nums[i] 为奇数时，i 也是 奇数 ；当 nums[i] 为偶数时， i 也是 偶数 。
 * 你可以返回 任何满足上述条件的数组作为答案 。
 */
public class SortArrayByParityII {

    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        int i = 0, j = 1;
        while (i < n && j < n) {
            //找到偶数位置的奇数
            while (i < n && nums[i] % 2 == 0) {
                i += 2;
            }
            //找到奇数位置的偶数
            while (j < n && nums[j] % 2 == 1) {
                j += 2;
            }
            if (i < n && j < n) {
                swap(nums, i, j);
            }
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
