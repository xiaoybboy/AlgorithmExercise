package com.offer1;

import com.model.TreeNode;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 
 * @author XIAO
 *
 */
public class ReverseTreeNodeMirror {

	public void Mirror(TreeNode root) {
		if (root == null)
			return;
		if (root.left == null && root.right == null)
			return;
		// 交换左右子树
		TreeNode tmp = null;
		tmp = root.right;
		root.right = root.left;
		root.left = tmp;
		// 递归
		if (root.left != null)
			Mirror(root.left);
		if (root.right != null)
			Mirror(root.right);
	}
}
