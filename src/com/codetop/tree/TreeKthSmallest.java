package com.codetop.tree;

import com.baseAlgorithm.tree.TreeNode;

/**
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 */
public class TreeKthSmallest {

    int k, res;

    /**
     * 二叉搜索树中序遍历，找到第k个元素停止
     * <p>
     * 中序遍历模板
     * if (node == null) {
     * return;
     * }
     * midOrder(node.left);
     * // do something...
     * midOrder(node.right);
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        midOrder(root);
        return res;
    }

    void midOrder(TreeNode root) {
        if (root == null) return;
        midOrder(root.left);
        k--;
        if (k == 0) {
            res = root.val;
        }
        midOrder(root.right);
    }
}
