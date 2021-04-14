package com.sword.offer;

import com.baseAlgorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 分别按照二叉树先序，中序和后序打印所有的节点
 */
public class TreeNodeThreeOrder {

    public int[][] threeOrders(TreeNode root) {
        int size = getNums(root);
        int[][] res = new int[3][size];
        List<Integer> list = new ArrayList<>();
        preOrder(root, list);
        for (int i = 0; i < size; i++) {
            res[0][i] = list.get(i);
        }
        list = new ArrayList<>();
        inOrder(root, list);
        for (int i = 0; i < size; i++) {
            res[1][i] = list.get(i);
        }
        list = new ArrayList<>();
        postOrder(root, list);
        for (int i = 0; i < size; i++) {
            res[2][i] = list.get(i);
        }
        return res;
    }

    public int getNums(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + getNums(root.left) + getNums(root.right);
    }

    /**
     * 先序遍历
     *
     * @param root
     * @param list
     */
    public void preOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }

    /**
     * 中序遍历
     *
     * @param root
     * @param list
     */
    public void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    /**
     * 后序遍历
     *
     * @param root
     * @param list
     */
    public void postOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.val);
    }
}
