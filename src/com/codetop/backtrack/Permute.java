package com.codetop.backtrack;

import java.util.*;


public class Permute {

    List<List<Integer>> result = new ArrayList<>();

    /**
     * 全排列:给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     * <p>
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     */
    public List<List<Integer>> permute(int[] nums) {
        backTrack(0, nums);
        return result;
    }

    private void backTrack(int start, int[] nums) {
        if (start == nums.length - 1) {
            List<Integer> tempList = new ArrayList<>();
            for (int num : nums) {
                tempList.add(num);
            }
            result.add(tempList);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            backTrack(start + 1, nums);
            swap(nums, i, start);
        }
    }

    /**
     * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute2(int[] nums) {
        Arrays.sort(nums);
        backTrack2(0, nums);
        return result;
    }

    private void backTrack2(int start, int[] nums) {
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
            if (set.contains(nums[i])) {
                // 重复，因此剪枝
                continue;
            }
            set.add(nums[i]);
            swap(nums, start, i);
            backTrack2(start + 1, nums);
            swap(nums, i, start);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
