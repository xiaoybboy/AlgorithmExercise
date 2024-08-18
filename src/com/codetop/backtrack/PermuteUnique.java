package com.codetop.backtrack;

import java.util.*;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列
 */
public class PermuteUnique {

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        permuteUnique(nums);
    }

    static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        backTrack(nums, 0);
        return result;
    }

    private static void backTrack(int[] nums, int start) {
        if (start == nums.length - 1) {
            List<Integer> tempList = new ArrayList<>();
            for (int num : nums) {
                tempList.add(num);
            }
            result.add(tempList);
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            //例如1223，当i=0的时候，交换1和2，以及交换1和第二个2结果都是一样。需要跳过，直接和3交换
            if (set.contains(nums[i])) {
                // 重复，因此剪枝
                continue;
            }
            set.add(nums[i]);
            swap(nums, start, i);
            backTrack(nums, start + 1);
            swap(nums, i, start);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
