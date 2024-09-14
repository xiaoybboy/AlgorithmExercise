package com.codetop.tree;

import com.model.TreeNode;

/**
 * 给定两棵二叉树 tree1 和 tree2，判断 tree2 是否以 tree1 的某个节点为根的子树具有 相同的结构和节点值 。
 * 注意，空树 不会是以 tree1 的某个节点为根的子树具有 相同的结构和节点值 。
 */
public class IsSubStructure {

    public boolean isSubStructure2(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return isContains(A, B) || isSubStructure2(A.left, B) || isSubStructure2(A.right, B);
    }

    private boolean isContains(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return isContains(A.left, B.left) && isContains(A.right, B.right);
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    /**
     * A是否包含B
     *
     * @param A
     * @param B
     * @return
     */
    private boolean recur(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}
