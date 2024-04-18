package com.codetop.tree;

import com.model.ListNode;
import com.model.TreeNode;

/**
 * 给定一个单链表的头节点  head ，其中的元素 按升序排序 ，将其转换为
 * 平衡
 * 二叉搜索树。
 */
public class SortedListToBST {

    /**
     * 找出链表元素的中位数作为根节点的值
     */
    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head, null);
    }

    public TreeNode buildTree(ListNode left, ListNode right) {
        if (left == right) {
            return null;
        }
        ListNode mid = getMidNode(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildTree(left, mid);
        root.right = buildTree(mid.next, right);
        return root;
    }

    /**
     * 获取中间节点作为根节点
     */
    public ListNode getMidNode(ListNode left, ListNode right) {
        ListNode slow = left;
        ListNode fast = left;
        while (fast != right && fast.next != right) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
