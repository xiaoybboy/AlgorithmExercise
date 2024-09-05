package com.codetop.bfs;

import com.model.TreeNode;

import java.util.LinkedList;

/**
 * 给你一棵二叉树的根节点 root ，返回树的 最大宽度 。
 * 树的 最大宽度 是所有层中最大的 宽度 。
 * 每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。将这个二叉树视作与满二叉树结构相同，
 * 两端点间会出现一些延伸到这一层的 null 节点，这些 null 节点也计入长度。
 * 题目数据保证答案将会在  32 位 带符号整数范围内。
 */
public class widthOfBinaryTree {

    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        root.val = 1;
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            maxWidth = Math.max(maxWidth, queue.peekLast().val - queue.peekFirst().val + 1);

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    node.left.val = 2 * node.val - 1;
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    node.right.val = 2 * node.val;
                    queue.offer(node.right);
                }
            }
        }
        return maxWidth;
    }
}
