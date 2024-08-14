package com.codetop.tree;

import com.baseAlgorithm.tree.TreeNode;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 */
public class LowestCommonAncestor {

    //终止条件：
    //当越过叶节点，则直接返回 null ；
    //当 root 等于 p,q ，则直接返回 root ；
    //递推工作：
    //开启递归左子节点，返回值记为 left ；
    //开启递归右子节点，返回值记为 right ；
    //返回值： 根据 left 和 right ，可展开为四种情况；
    //当 left 和 right 同时为空 ：说明 root 的左 / 右子树中都不包含 p,q ，返回 null ；
    //当 left 和 right 同时不为空 ：说明 p,q 分列在 root 的 异侧 （分别在 左 / 右子树），因此 root 为最近公共祖先，返回 root ；
    //当 left 为空 ，right 不为空 ：p,q 都不在 root 的左子树中，直接返回 right 。具体可分为两种情况：
    //p,q 其中一个在 root 的 右子树 中，此时 right 指向 p（假设为 p ）；
    //p,q 两节点都在 root 的 右子树 中，此时的 right 指向 最近公共祖先节点 ；
    //当 left 不为空 ， right 为空 ：与情况 3. 同理；
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //1.终止条件
        if (root == null || root == p || root == q) {
            return root;
        }
        //2.搜索左右子树
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //3.1,左右子树中都没有
        if (left == null && right == null) {
            return null;
        }
        //3.2,左右子树中都有,说明q和q分列root的两侧
        if (left != null && right != null) {
            return root;
        }
        //3.3，左右子树中一边存在
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
        return root;
    }
}
