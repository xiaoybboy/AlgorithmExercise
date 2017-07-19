package com.company.qunar;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 给定一棵二叉树的前序（根、左、右）和中序（左、根、右）的打印结果，输出此二叉树按层（从左往右）打印结果。
 * 
 * 例如一棵二叉树前序：1 2 4 5 3；中序：4 2 5 1 3。可以构建出下图所示二叉树：
 * 
 * 按层打印的结果则为：1 2 3 4 5。
 * 
 * 
 * 输入 第一行只有一个数字，表示二叉树的节点数n（1<=n<=1000）;
 * 第二行由a1,a2,...,an(1<=ai<=1000)组成的整数序列（用空格分隔）—表示前序打印结果；
 * 第三行由b1,b2,...,bn(1<=bi<=1000)组成的整数序列（用空格分隔）—表示中序打印结果。
 * 
 * 样例输入
 * 
 * 5
 * 
 * 1 2 4 5 3
 * 
 * 4 2 5 1 3
 * 
 * 输出 c1,c2,...,cn，用空格分隔—表示按层打印的结果。
 * 
 * 样例输出
 * 
 * 1 2 3 4 5
 * 
 * @author XIAO
 *
 */
public class PrintBtree {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] pre = new int[n];
		int[] mid = new int[n];

		for (int i = 0; i < n; i++) {
			pre[i] = sc.nextInt();
		}

		for (int j = 0; j < n; j++) {
			mid[j] = sc.nextInt();
		}

		TreeNode root = rebuildTree(pre, 0, n - 1, mid, 0, n - 1);
		PrintTree(root);
	}

	/**
	 * 按照层次打印二叉树
	 * 
	 * @param root
	 */
	private static void PrintTree(TreeNode root) {
		if (root == null)
			return;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		while (!q.isEmpty()) {
			TreeNode t = q.poll();
			System.out.print(t.val + " ");
			if (t.left != null)
				q.offer(t.left);
			if (t.right != null)
				q.offer(t.right);
		}
	}

	/**
	 * 使用先序遍历和中序遍历构建二叉树
	 * 
	 * @param pre
	 * @param k
	 * @param j
	 * @param mid
	 * @param m
	 * @param l
	 * @return
	 */
	private static TreeNode rebuildTree(int[] pre, int startPre, int endPre, int[] mid, int startmid, int endmid) {
		if (startPre > endPre || startmid > endmid) {
			return null;
		}
		TreeNode root = new TreeNode(pre[startPre]);
		for (int i = startmid; i <= endmid; i++)
			if (mid[i] == pre[startPre]) {
				root.left = rebuildTree(pre, startPre + 1, startPre + i - startmid, mid, startmid, i - 1);
				root.right = rebuildTree(pre, i - endmid + startPre + 1, endPre, mid, i + 1, endmid);
			}
		return root;
	}

}
