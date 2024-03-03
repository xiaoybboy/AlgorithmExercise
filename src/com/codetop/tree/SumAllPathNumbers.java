package com.codetop.tree;

import com.baseAlgorithm.tree.TreeNode;

/**
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * <p>
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 */
public class SumAllPathNumbers {

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode node, int preNum) {
        if (node == null) {
            return 0;
        }
        preNum = preNum * 10 + node.val;
        if (node.left == null && node.right == null) {
            return preNum;
        } else {
            return dfs(node.left, preNum) + dfs(node.right, preNum);
        }
    }
}
