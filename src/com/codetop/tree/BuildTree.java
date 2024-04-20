package com.codetop.tree;


import com.model.TreeNode;

import java.util.HashMap;

/**
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 */
public class BuildTree {

    int[] preorder;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return rebuild(0, 0, inorder.length - 1);
    }

    //rootPreIndex: 根节点在前序遍历中的下标
    //left: 中序遍历中的左边界
    //right: 中序遍历中的右边界
    public TreeNode rebuild(int rootPreIndex, int left, int right) {
        if (left > right) {
            return null;
        }
        //根节点在中序遍历中的下标
        int rootMidIndex = map.get(preorder[rootPreIndex]);
        TreeNode rootNode = new TreeNode(preorder[rootPreIndex]);
        rootNode.left = rebuild(rootPreIndex + 1, left, rootMidIndex - 1);
        //左子树的元素个数 rootMidIndex - left
        rootNode.right = rebuild(rootPreIndex + rootMidIndex - left + 1, rootMidIndex + 1, right);
        return rootNode;
    }
}
