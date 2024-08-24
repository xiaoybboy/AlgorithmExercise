package com.codetop.backtrack;

import java.util.*;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列
 */
public class PermuteUnique {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> tempList = new LinkedList<>();
    boolean[] used;

    public List<List<Integer>> permuteUnique2(int[] nums) {
        used = new boolean[nums.length];
        permuteUniqueHelper(nums);
        return result;
    }

    public void permuteUniqueHelper(int[] nums) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        Set<Integer> brother = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || brother.contains(nums[i])) {
                continue;
            }
            brother.add(nums[i]);
            tempList.add(nums[i]);
            used[i] = true;
            permuteUniqueHelper(nums);
            tempList.removeLast();
            used[i] = false;
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        backTrack(nums, 0);
        return result;
    }

    private void backTrack(int[] nums, int start) {
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
