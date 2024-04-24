package com.codetop.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combine {

    List<List<Integer>> result = new ArrayList<>();

    /**
     * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
     * <p>
     * 你可以按 任何顺序 返回答案。
     */
    public List<List<Integer>> combine(int n, int k) {
        backTrack(1, n, k, new ArrayList<>());
        return result;
    }

    private void backTrack(int start, int n, int k, List<Integer> tempList) {
        if (k == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        //环结束条件默认为最大值到 n，这里可以优化进行剪枝，比如 n=4，k=3 时，
        // 如果列表从 start=3 也就是 [3] 开始，那么该组合一定不存在，
        // 因为至少要 k=3 个数据，所以剪枝临界点为 n-balance+1
        for (int i = start; i <= n - k + 1; i++) {
            tempList.add(i);
            backTrack(i + 1, n, k - 1, tempList);
            tempList.remove(tempList.size() - 1);
        }
    }

    /**
     * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，
     * 找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。
     * 你可以按 任意顺序 返回这些组合。
     * <p>
     * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
     * <p>
     * 输入：candidates = [2,3,6,7], target = 7
     * * 输出：[[2,2,3],[7]]
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTrack2(0, candidates, target, new ArrayList<>());
        return result;
    }

    private void backTrack2(int start, int[] candidates, int target, List<Integer> tempList) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(tempList));
        }
        for (int i = start; i < candidates.length; i++) {
            tempList.add(candidates[i]);
            //可重复选取，所以这里还从i开始
            backTrack2(i, candidates, target - candidates[i], tempList);
            tempList.remove(tempList.size() - 1);
        }
    }

    /**
     * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * <p>
     * candidates 中的每个数字在每个组合中只能使用 一次 。
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); // 对 candidates 进行排序
        backTrack3(0, candidates, target, new ArrayList<>());
        return result;
    }

    private void backTrack3(int start, int[] candidates, int target, List<Integer> tempList) {
        if (target == 0) {
            result.add(new ArrayList<>(tempList));
        }
        for (int i = start; i < candidates.length; i++) {
            if (target < 0) {
                break;
            }
            // 剪枝四：如果该元素与左边元素相等，说明该搜索分支重复，直接跳过
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            tempList.add(candidates[i]);
            backTrack3(i + 1, candidates, target - candidates[i], tempList);
            tempList.remove(tempList.size() - 1);
        }
    }

    /**
     * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
     * <p>
     * 只使用数字1到9
     * 每个数字 最多使用一次
     * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        backTrack4(1, n, k, new ArrayList<>());
        return result;
    }

    private void backTrack4(int start, int n, int k, List<Integer> tempList) {
        if (tempList.size() == k && n == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i <= 9; i++) {
            if (n < 0) {
                break;
            }
            tempList.add(i);
            backTrack4(i + 1, n - i, k, tempList);
            tempList.remove(tempList.size() - 1);
        }
    }
}
