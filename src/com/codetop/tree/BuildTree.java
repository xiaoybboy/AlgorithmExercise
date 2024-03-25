package com.codetop.tree;


import com.model.TreeNode;

/**
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 */
public class BuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int pleft, int pright, int[] inorder, int ileft, int iright) {
        if (pleft > pright || ileft > iright) {
            return null;
        }
        //根节点值是前序遍历的第一个
        TreeNode root = new TreeNode(preorder[pleft]);
        //中序遍历第一个为起始点
        int middle = ileft;
        //左子树节点长度
        int len = 0;
        //找到中序遍历中的根节点位置记为middle
        for (; middle < inorder.length; middle++) {
            if (inorder[middle] == preorder[pleft]) {
                break;
            }
            //计算左子树节点长度len
            len++;
        }
        //递归调用求解左右子树
        //左子树：前序遍历为根后一个到根加左子树长度，中序遍历为第一个到根节点位置前一个
        root.left = buildTree(preorder, pleft + 1, pleft + len, inorder, ileft, middle - 1);
        //右子树：前序遍历为左子树后一个到最后一个，中序为根节点后一个到最后一个
        root.right = buildTree(preorder, pleft + len + 1, pright, inorder, middle + 1, iright);
        return root;
    }
}
