package com.codetop.backtrack;

import com.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSum {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum, new ArrayList<>());
        return result;
    }

    public void dfs(TreeNode node, int sum, List<Integer> tempList) {
        if (node == null) {
            return;
        }
        tempList.add(node.val);
        sum -= node.val;
        if (node.left == null && node.right == null && sum == 0) {
            result.add(new ArrayList<>(tempList));
        } else {
            dfs(node.left, sum, tempList);
            dfs(node.right, sum, tempList);
        }
        tempList.remove(tempList.size() - 1);
    }
}
