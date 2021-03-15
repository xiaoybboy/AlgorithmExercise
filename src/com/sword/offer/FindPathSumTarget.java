package com.sword.offer;

import com.model.TreeNode;

import java.util.ArrayList;

/**
 * 输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class FindPathSumTarget {

    private ArrayList<ArrayList<Integer>> path = new ArrayList<>();
    private ArrayList<Integer> data = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return path;
        }
        data.add(root.val);
        target -= root.val;
        if (target == 0 && root.right == null && root.left == null) {
            path.add(new ArrayList<>(data));
        }
        FindPath(root.left, target);
        FindPath(root.right, target);

        data.remove(data.size() - 1);
        return path;
    }
}
