package com.sword.offer;

import com.model.TreeNode;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向
 */
public class ConvertTreeNode {

    TreeNode pre = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        Convert(pRootOfTree.right);
        if (pre == null)
            pre = pRootOfTree;
        else {
            pRootOfTree.right = pre;
            pre.left = pRootOfTree;
            pre = pRootOfTree;
        }
        Convert(pRootOfTree.left);
        return pre;
    }
}
