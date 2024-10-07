package com.codetop.tree;

import com.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 */
public class BuildTree2 {

    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(postorder, n - 1, 0, n - 1);
    }

    //rootInPostOrderIndex:根节点在后续遍历中的位置
    private TreeNode buildTree(int[] postOrder, int rootInPostOrderIndex, int start, int end) {
        if (start > end) {
            return null;
        }
        int rootVal = postOrder[rootInPostOrderIndex];
        TreeNode root = new TreeNode(rootVal);
        int inOrderIndex = map.get(rootVal);
        //左子树的根节点：rootInPostOrderIndex - (end - inOrderIndex+1)，end - inOrderIndex + 1是右子树的长度
        root.left = buildTree(postOrder, rootInPostOrderIndex - (end - inOrderIndex + 1), start, inOrderIndex - 1);
        //右子树的根节点位置，在上一个根节点的前一个节点
        root.right = buildTree(postOrder, rootInPostOrderIndex - 1, inOrderIndex + 1, end);
        return root;
    }
}
