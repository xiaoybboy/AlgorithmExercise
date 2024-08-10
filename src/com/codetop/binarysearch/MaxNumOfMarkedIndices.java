package com.codetop.binarysearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个下标从 0 开始的整数数组 nums 。
 * <p>
 * 一开始，所有下标都没有被标记。你可以执行以下操作任意次：
 * <p>
 * 选择两个 互不相同且未标记 的下标 i 和 j ，满足 2 * nums[i] <= nums[j] ，标记下标 i 和 j 。
 * 请你执行上述操作任意次，返回 nums 中最多可以标记的下标数目。
 */
public class MaxNumOfMarkedIndices {

    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> colorIndexs = new HashSet<>();
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = check(nums, i, colorIndexs);
            if (n == nums.length) {
                break;
            } else {
                result++;
                colorIndexs.add(i);
                colorIndexs.add(n);
            }
        }
        return result;
    }

    public int check(int[] nums, int curIndex, Set<Integer> colorIndexs) {
        int start = curIndex, end = nums.length;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= 2 * nums[curIndex] && !colorIndexs.contains(nums[mid])) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return end;
    }
}
