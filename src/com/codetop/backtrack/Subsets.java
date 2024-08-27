package com.codetop.backtrack;

import java.util.*;


public class Subsets {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> tempList = new LinkedList<>();

    /**
     * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的
     * 子集（幂集）。
     * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
     */
    public List<List<Integer>> subsets(int[] nums) {
        backTrack(0, nums);
        return result;
    }

    private void backTrack(int start, int[] nums) {
        result.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backTrack(i + 1, nums);
            tempList.removeLast();
        }
    }

    /**
     * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
     * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backTrack2(0, nums);
        return result;
    }

    private void backTrack2(int start, int[] nums) {
        result.add(new ArrayList<>(tempList));
        Set<Integer> brother = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            //横向剪枝
            if (brother.contains(nums[i])) {
                continue;
            }
            brother.add(nums[i]);
            tempList.add(nums[i]);
            backTrack2(i + 1, nums);
            tempList.removeLast();
        }
    }

    /**
     * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，
     * 递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
     * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        findSubsequencesTrack(0, nums);
        return result;
    }

    private void findSubsequencesTrack(int start, int[] nums) {
        //结果
        if (tempList.size() > 1) {
            result.add(new ArrayList<>(tempList));
        }
        Set<Integer> brother = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            // 如果上一个加入子集的数比当前准备加入的数大，则接着尝试下一个数看能否找到比上一个数更大的数加入子集
            if (!tempList.isEmpty() && tempList.peekLast() > nums[i]) {
                continue;
            }
            //剪枝
            if (brother.contains(nums[i])) {
                continue;
            }
            brother.add(nums[i]);
            tempList.add(nums[i]);
            findSubsequencesTrack(i + 1, nums);
            tempList.removeLast();
        }
    }
}
