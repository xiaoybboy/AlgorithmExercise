package com.codetop.tree;


import com.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 */
public class BuildTree {

    Map<Integer, Integer> inOrderMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int rootPreOrderIndex, int start, int end) {
        if (start > end) {
            return null;
        }
        int rootVal = preorder[rootPreOrderIndex];
        TreeNode root = new TreeNode(rootVal);
        //获取根节点在中序遍历位置
        int inOrderRootIndex = inOrderMap.get(rootVal);
        //递归构造左子树和右子树
        //前序序列中，某个根节点的下一个节点，一定是左子树的根节点的位置
        root.left = buildTree(preorder, rootPreOrderIndex + 1, start, inOrderRootIndex - 1);
        //前序序列中，左子树的长度为inOrderRootIndex-start+1,所以右子树根节点的位置就是 rootPreOrderIndex + (inOrderRootIndex - start + 1)
        root.right = buildTree(preorder, rootPreOrderIndex + (inOrderRootIndex - start + 1), inOrderRootIndex + 1, end);
        return root;
    }
}
