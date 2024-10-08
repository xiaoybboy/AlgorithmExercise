package com;


import com.model.TreeNode;

import java.util.ArrayDeque;

public class Test {

    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 0;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        root.val = 1;

        while (!queue.isEmpty()) {
            maxWidth = Math.max(maxWidth, queue.peekLast().val - queue.peekFirst().val + 1);
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    node.left.val = node.val * 2 - 1;
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    node.right.val = node.val * 2;
                    queue.offer(node.right);
                }
            }
        }
        return maxWidth;
    }
}
