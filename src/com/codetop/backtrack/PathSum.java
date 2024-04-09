package com.codetop.backtrack;

import com.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSum {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        backTrack(root, targetSum, new ArrayList<>());
        return result;
    }

    public void backTrack(TreeNode node, int sum, List<Integer> tempList) {
        if (node == null) {
            return;
        }
        tempList.add(node.val);
        sum -= node.val;
        if (node.left == null && node.right == null && sum == 0) {
            result.add(new ArrayList<>(tempList));
        } else {
            backTrack(node.left, sum, tempList);
            backTrack(node.right, sum, tempList);
        }
        tempList.remove(tempList.size() - 1);
    }
}
