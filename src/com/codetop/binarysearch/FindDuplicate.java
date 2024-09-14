package com.codetop.binarysearch;

/**
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
 * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 */
public class FindDuplicate {

    /**
     * 1.随便猜一个数target（取数组中间的数次数少），判断整个数组中≤target的数量count。
     * 2.显然，如果没有重复,count的数量应该≤target.如果>,必然存在重复。
     * 3.划分蓝红区域：蓝色count>target，也就是左侧存在重复。
     * 4.right就是我们要找的重复数
     */
    public int findDuplicate(int[] nums) {
        int start = -1, end = nums.length;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isDuplicate(nums, mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return end;
    }

    private boolean isDuplicate(int[] nums, int mid) {
        int count = 0;
        for (int x : nums) {
            if (x <= mid) {
                count++;
                if (count > mid) {
                    return true;
                }
            }
        }
        return false;
    }
}
