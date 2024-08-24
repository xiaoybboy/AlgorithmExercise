package com.codetop.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Combine {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> tempList = new LinkedList<>();

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
        if (tempList.size() == k) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i <= n; i++) {
            //剪枝，如果剩余的数全取，也没法满足k个数的需求，则停止
            if (tempList.size() + (n - i + 1) < k) {
                break;
            }
            tempList.add(i);
            backTrack(i + 1, n, k, tempList);
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
        backTrack4(1, n, k, 0);
        return result;
    }

    private void backTrack4(int start, int n, int k, int curSum) {
        if (tempList.size() == k) {
            if (curSum == n) {
                result.add(new ArrayList<>(tempList));
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            curSum += i;
            if (tempList.size() + (n - i + 1) < k || curSum > n) {
                break;
            }
            tempList.add(i);
            backTrack4(i + 1, n, k, curSum);
            tempList.remove(tempList.size() - 1);
            curSum -= i;
        }
    }

    /**
     * 给你一个无重复元素 的整数数组 candidates 和一个目标整数 target ，
     * 找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。
     * 你可以按 任意顺序 返回这些组合。
     * <p>
     * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
     * <p>
     * 输入：candidates = [2,3,6,7], target = 7
     * * 输出：[[2,2,3],[7]]
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTrack(candidates, 0, target);
        return result;
    }

    private void backTrack(int[] candidates, int start, int curTarget) {
        if (curTarget == 0) {
            result.add(new ArrayList<>(tempList));
        }
        if (curTarget < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            tempList.add(candidates[i]);
            backTrack(candidates, i, curTarget - candidates[i]);
            tempList.remove(tempList.size() - 1);
        }
    }

    /**
     * 给定一个候选人编号的集合 candidates 和一个目标数 target,
     * 找出 candidates 中所有可以使数字和为 target 的组合。
     * <p>
     * candidates 中的每个数字在每个组合中只能使用 一次 。
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); // 对 candidates 进行排序
        backtrack(target, candidates, 0);
        return result;
    }

    private void backtrack(int target, int[] candidates, int start) {
        // 子集和等于 target 时，记录解
        if (target == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        // 遍历所有选择
        // 剪枝二：从 start 开始遍历，避免生成重复子集
        // 剪枝三：从 start 开始遍历，避免重复选择同一元素
        for (int i = start; i < candidates.length; i++) {
            // 剪枝一：若子集和超过 target ，则直接结束循环
            // 这是因为数组已排序，后边元素更大，子集和一定超过 target
            if (target - candidates[i] < 0) {
                break;
            }
            // 剪枝四：如果该元素与左边元素相等，说明该搜索分支重复，直接跳过
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            // 尝试：做出选择，更新 target, start
            tempList.add(candidates[i]);
            // 进行下一轮选择
            backtrack(target - candidates[i], candidates, i + 1);
            // 回退：撤销选择，恢复到之前的状态
            tempList.remove(tempList.size() - 1);
        }
    }
}
