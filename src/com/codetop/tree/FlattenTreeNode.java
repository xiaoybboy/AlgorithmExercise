package com.codetop.tree;

import com.model.TreeNode;

import java.util.Stack;

/**
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * <p>
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 */
public class FlattenTreeNode {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode pre = null;//当前链表节点
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (pre != null) {
                pre.right = node;
                pre.left = null;
            }

            //先放右边节点，出栈的时候，后出
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            pre = node;
        }
    }
}
