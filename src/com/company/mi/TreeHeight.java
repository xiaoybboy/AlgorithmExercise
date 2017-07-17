package com.company.mi;

import java.util.Scanner;

/**
 * 现在有一棵合法的二叉树，树的节点都是用数字表示，现在给定这棵树上所有的父子关系，求这棵树的高度
 * 
 * 输入
 * 
 * 输入的第一行表示节点的个数n（1<=n<=1000，节点的编号为0到n-1）组成，
 * 下面是n-1行，每行有两个整数，第一个数表示父节点的编号，第二个数表示子节点的编号
 * 
 * 样例输入
 * 
 * 5
 * 
 * 0 1
 * 
 * 0 2
 * 
 * 1 3
 * 
 * 1 4
 * 
 * 输出 输出树的高度，为一个整数
 * 
 * 样例输出
 * 
 * 3
 * 
 * @author XIAO
 *
 */
public class TreeHeight {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int m = scanner.nextInt();
			TreeNode rootNode = new TreeNode(scanner.nextInt());
			createTree(rootNode, rootNode.val, scanner.nextInt());
			for (int i = 1; i < m - 1; i++) {
				createTree(rootNode, scanner.nextInt(), scanner.nextInt());
			}

			int height = getTreeHeight(rootNode);
			System.out.println(height);
		}
		scanner.close();
	}

	/**
	 * 求树的高度
	 * 
	 * @param rootNode
	 * @return
	 */
	private static int getTreeHeight(TreeNode rootNode) {
		if (rootNode == null) {
			return 0;
		}
		int nLeft = getTreeHeight(rootNode.left);
		int nRight = getTreeHeight(rootNode.right);
		return (nLeft > nRight) ? (nLeft + 1) : (nRight + 1);
	}

	/**
	 * 建树
	 * 
	 * @param root
	 * @param father
	 * @param childVal
	 */
	public static void createTree(TreeNode root, int father, int childVal) {
		if (root == null) {
			return;
		}
		if (root != null && root.val == father) {
			if (root.left == null) {// 左孩子为空即将其作为左孩子节点
				root.left = new TreeNode(childVal);
			} else {// 作为右孩子节点
				root.right = new TreeNode(childVal);
			}
			return;
		}

		createTree(root.left, father, childVal);
		createTree(root.right, father, childVal);
	}
}

/**
 * 对象： 树
 * 
 */
class TreeNode {
	TreeNode left;
	TreeNode right;
	int val;

	public TreeNode(int val) {
		this.val = val;
	}

}
