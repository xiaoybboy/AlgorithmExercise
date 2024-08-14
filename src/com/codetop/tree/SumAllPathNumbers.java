package com.codetop.tree;

import com.baseAlgorithm.tree.TreeNode;

/**
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * <p>
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 */
public class SumAllPathNumbers {

    int totalSum = 0;
    public int sumNumbers2(TreeNode root) {
        path(root, 0);
        return totalSum;
    }

    private void path(TreeNode curNode, int preSum) {
        preSum = preSum * 10 + curNode.val;
        if (curNode.left == null && curNode.right == null) {
            totalSum += preSum;
            return;
        }
        if (curNode.left != null) {
            path(curNode.left, preSum);
        }
        if (curNode.right != null) {
            path(curNode.right, preSum);
        }
    }

    int sum = 0;

    public int sumNumbers(TreeNode root) {
        dfs(0, root);
        return sum;
    }

    public void dfs(int preSum, TreeNode node) {
        preSum = preSum * 10 + node.val;
        //如果到达叶子节点，加上路径的值并返回
        if (node.left == null && node.right == null) {
            sum += preSum;
            return;
        }
        //左子树
        if (node.left != null) {
            dfs(preSum, node.left);
        }
        //右子树
        if (node.right != null) {
            dfs(preSum, node.right);
        }
    }
}
