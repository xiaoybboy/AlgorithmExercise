package com.codetop.backtrack;

import com.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSum {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> tempList = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return result;
    }

    public void dfs(TreeNode node, int sum) {
        if (node == null) {
            return;
        }
        tempList.add(node.val);
        sum -= node.val;
        if (sum < 0) {
            return;
        }
        if (node.left == null && node.right == null && sum == 0) {
            result.add(new ArrayList<>(tempList));
        } else {
            dfs(node.left, sum);
            dfs(node.right, sum);
        }
        tempList.remove(tempList.size() - 1);
    }
}
