package com.offer2;

import com.model.TreeNode;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 思路：解题思路：
	1.将左子树构造成双链表，并返回链表头节点。
	2.定位至左子树双链表最后一个节点。
	3.如果左子树链表不为空的话，将当前root追加到左子树链表。
	4.将右子树构造成双链表，并返回链表头节点。
	5.如果右子树链表不为空的话，将该链表追加到root节点之后。
	6.根据左子树链表是否为空确定返回的节点。
	
 * @author XIAO
 *
 */
public class BinaryTreeLinkedList {
	public TreeNode Convert(TreeNode root) {
		if (root == null) {
			return null;
		}
		// 如果root的左右子树都为空
		if (root.left == null && root.right == null) {
			return root;
		}
		TreeNode left = Convert(root.left);// 把root节点的左子树转成链表，返回值为链表的头
		TreeNode p = left;
		while (p != null && p.right != null) {
			p = p.right;// 循环定位到左子树双链表的最后一个节点
		}
		// 如果左子树链表不为空的话，将当前root追加到左子树链表
		if (left != null) {
			p.right = root;// 把root连接到左子树形成的双向链表中，双向链表，需要左右都连接
			root.left = p;
		}
		// 同样的，把根节点的右子树也形成双向链表，返回值为链表头
		TreeNode right = Convert(root.right);
		// 把右子树的链表连接到上面的左子树和根节点的链表中
		if (right != null) {
			root.right = right;// 同样把右子树的链表连接上去
			right.left = root;
		}
		return left != null ? left : root;
	}
}
