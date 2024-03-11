package com.codetop.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列:给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class Permute {

    List<List<Integer>> result = new ArrayList<>();

    /**
     * void process(参数) {
     *     if (终止条件) {
     *         存放结果;
     *         return;
     *     }
     *
     *     for (选择：本次递归集合中元素（从开始下标到数组结尾）) {
     *         处理节点;
     *         process(参数); // 递归
     *         回溯，撤销处理结果
     *     }
     * }
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return result;
        }
        backTrace(0, nums.length, nums);
        return result;
    }

    public void backTrace(int i, int len, int[] nums) {
        if (i == len - 1) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            result.add(list);
            return;
        }
        for (int j = i; j < len; j++) {
            swap(nums, i, j);
            backTrace(i + 1, len, nums);
            swap(nums, i, j);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
