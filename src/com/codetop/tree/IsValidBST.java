package com.codetop.tree;

import com.model.TreeNode;

/**
 * 98. 验证二叉搜索树
 */
public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long lower, long higher) {
        if (root == null) {
            return true;
        }
        if (root.val <= lower || root.val >= higher) {
            return false;
        }
        return isValidBST(root.left, lower, root.val) && isValidBST(root.right, root.val, higher);
    }
}

