package com.codetop.tree;

import com.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 */
public class BuildTree2 {

    //保存每个节点在中序遍历中的位置，方便计算
    Map<Integer, Integer> map = new HashMap<>();
    //后续遍历
    int[] post;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        post = postorder;
        TreeNode root = buildTree(0, inorder.length - 1, 0, post.length - 1);
        return root;
    }

    public TreeNode buildTree(int inorderStart, int inorderEnd, int postorderStart, int postOrderEnd) {
        if (inorderEnd < inorderStart || postOrderEnd < postorderStart) {
            return null;
        }
        //根节点-后续遍历的最后一个节点
        int root = post[postOrderEnd];
        //根节点在中序遍历中的位置
        int rootIndex = map.get(root);

        TreeNode node = new TreeNode(root);
        //考虑中序：9,3,15,20,7;后序：9,15,7,20,3
        //中序的左右子树很好计算，中序根节点的位置-1,+1即可
        //后序：postOrderEnd - 1 表示去掉最后的根节点的位置，比如第一次的20；rootIndex - inorderStart 表示左子树的长度，比如第一次长度就是1
        node.left = buildTree(inorderStart, rootIndex - 1, postorderStart, (postorderStart - 1) + (rootIndex - inorderStart));
        //右子树：rootIndex - inorderStart，左子树长度 + postorderStart 就是右子树的开始
        node.right = buildTree(rootIndex + 1, inorderEnd, postorderStart + (rootIndex - inorderStart), postOrderEnd - 1);
        return node;
    }
}
