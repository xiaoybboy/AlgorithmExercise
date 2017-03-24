package com.exercise1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

import com.model.TreeNode;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。 思路：借助一个队列实现
 * 
 * @author XIAO
 *
 */

public class TreeNodePrint {
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<>();// 保存结果
		if (root == null) {
			return list;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();// 从队列中取出一个节点
			if (node.left != null) {
				queue.offer(node.left);// 把该节点的左孩子放入队列
			}
			if (node.right != null) {
				queue.offer(node.right);// 把该节点的右孩子放入队列
			}
			list.add(node.val);

		}
		return list;
	}
}
