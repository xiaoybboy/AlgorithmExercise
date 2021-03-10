package com.sword.offer;

import com.model.TreeNode;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class MirrorTreeNode {

    /**
     * 递归
     *
     * @param pRoot
     * @return
     */
    public TreeNode Mirror(TreeNode pRoot) {
        if (pRoot == null) {
            return pRoot;
        }
        TreeNode temp = pRoot.left;
        pRoot.left = pRoot.right;
        pRoot.right = temp;
        Mirror(pRoot.left);
        Mirror(pRoot.right);
        return pRoot;
    }
}
