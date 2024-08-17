package com.baseAlgorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Combination Sum
 * Given a set ofcandidate numbers (C) and a target number (T), findall unique combinations in C where thecandidate
 * numbers sums toT.
 * The same repeated number may be chosen from C unlimited number of times.
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example,given candidate set [2, 3, 6, 7] and target 7,
 * A solution set is:
 * [
 * [7],
 * [2,2, 3]
 * ]
 * 每个数可以用多次
 *
 * @author XIAO
 * @create 2017-09-06 18:27
 **/
public class CombinSum {
    private static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        combinationSum(candidates, 7);
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);//所给数组可能无序，排序保证解按照非递减组合
        List<Integer> list = new ArrayList<>();
        backtracking(candidates, target, 0, list);//给定target，start=0表示从数组第一个开始
        return result;//返回解的组合链表
    }

    //允许重复放入
    private static void backtracking(int[] candidates, int target, int start, List<Integer> list) {
        if (target < 0) {
            return;
        } //凑过头了
        else if (target == 0) {
            result.add(new ArrayList<>(list));//正好凑出答案，开心地加入解的链表
        } else {
            for (int i = start; i < candidates.length; i++) {//循环试探每个数
                list.add(candidates[i]);//尝试加入
                //下一次凑target-candidates[i]，允许重复，还是从i开始
                backtracking(candidates, target - candidates[i], i, list);
                list.remove(list.size() - 1);//回退
            }
        }
    }
}