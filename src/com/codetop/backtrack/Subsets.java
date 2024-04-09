package com.codetop.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

    List<List<Integer>> result = new ArrayList<>();

    /**
     * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的
     * 子集
     * （幂集）。
     * <p>
     * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        backTrack(0, nums, new ArrayList<>());
        return result;
    }

    private void backTrack(int start, int[] nums, List<Integer> tempList) {
        result.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backTrack(i + 1, nums, tempList);
            tempList.remove(tempList.size() - 1);
        }
    }

    /**
     * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的
     * 子集
     * （幂集）。
     * <p>
     * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
     */
    List<List<Integer>> result2 = new ArrayList<>();

    public List<List<Integer>> subsets2(int[] nums) {
        Arrays.sort(nums);
        backTrack2(0, nums, new ArrayList<>());
        return result2;
    }

    private void backTrack2(int start, int[] nums, List<Integer> tempList) {
        result2.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            // 剪枝逻辑，值相同的相邻树枝，只遍历第一条
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            tempList.add(nums[i]);
            backTrack2(i + 1, nums, tempList);
            tempList.remove(tempList.size() - 1);
        }
    }
}
