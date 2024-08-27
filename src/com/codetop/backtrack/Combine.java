package com.codetop.backtrack;

import java.util.*;


public class Combine {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> tempList = new LinkedList<>();

    /**
     * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
     * <p>
     * 你可以按 任何顺序 返回答案。
     */
    public List<List<Integer>> combine(int n, int k) {
        backTrack(1, n, k);
        return result;
    }

    private void backTrack(int start, int n, int k) {
        if (tempList.size() == k) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        if (start > n) {
            return;
        }
        for (int i = start; i <= n; i++) {
            //剪枝，如果剩余的数全取，也没法满足k个数的需求，则停止
            if (tempList.size() + (n - i + 1) < k) {
                break;
            }
            tempList.add(i);
            backTrack(i + 1, n, k);
            tempList.removeLast();
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
     * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
     * 输入：candidates = [2,3,6,7], target = 7
     * * 输出：[[2,2,3],[7]]
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTrack(candidates, 0, 0, target);
        return result;
    }

    private void backTrack(int[] candidates, int start, int curSum, int target) {
        if (curSum == target) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        if (curSum > target) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            tempList.add(candidates[i]);
            curSum += candidates[i];
            backTrack(candidates, i, curSum, target);
            tempList.removeLast();
            curSum -= candidates[i];
        }
    }

    /**
     * 给定一个候选人编号的集合 candidates 和一个目标数 target,找出 candidates 中所有可以使数字和为 target 的组合。
     * candidates 中的每个数字在每个组合中只能使用 一次 。
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack2(target, candidates, 0);
        return result;
    }

    private void backtrack2(int target, int[] candidates, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        Set<Integer> brother = new HashSet<>();
        for (int i = start; i < candidates.length; i++) {
            //剪枝，同一层的重复元素剪掉
            if (brother.contains(candidates[i])) {
                continue;
            }
            //数组已经排序，越右边越大，剪枝
            if (target - candidates[i] < 0) {
                break;
            }
            tempList.add(candidates[i]);
            brother.add(candidates[i]);
            //注意要求每个元素最少使用一次，所以这里要从start+1开始
            backtrack2(target - candidates[i], candidates, i + 1);
            tempList.removeLast();
        }
    }
}
