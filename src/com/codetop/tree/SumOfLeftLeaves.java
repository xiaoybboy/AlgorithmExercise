package com.codetop.tree;

import com.model.TreeNode;

/**
 * 给定二叉树的根节点 root ，返回所有左叶子之和
 */
public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root);
    }

    public int dfs(TreeNode root) {
        int sum = 0;
        if (root.left != null) {
            sum += isLeafNode(root.left) ? root.left.val : dfs(root.left);
        }
        if (root.right != null && !isLeafNode(root.right)) {
            sum += dfs(root.right);
        }
        return sum;
    }

    public boolean isLeafNode(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
