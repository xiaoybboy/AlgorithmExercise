package com.exercise2;

import com.exercise1.TreeNode;

/**
 * 判断一棵树是不是平衡二叉树
 * 
 * 思路：递归求左右子树的深度，比较判断是否是平衡二叉树
 * 
 * @author XIAO
 *
 */
public class IsBalancedBinaryTree {
	public boolean IsBalanced_Solution(TreeNode root) {
		if (root == null) {
			return true;
		}
		int left = getDepth(root.left);
		int right = getDepth(root.right);
		if (Math.abs(left - right) > 1) {
			return false;
		}
		return true;
	}

	// 递归求解二叉树的深度
	private int getDepth(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int left = getDepth(node.left);
		int right = getDepth(node.right);
		return left > right ? left + 1 : right + 1;
	}
}
