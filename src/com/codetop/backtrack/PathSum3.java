package com.codetop.backtrack;

import com.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）
 */
public class PathSum3 {

    Map<Long, Integer> preSumCount = new HashMap<>();

    public int pathSum(TreeNode root, int targetSum) {
        preSumCount.put(0L, 1);
        return dfs(root, targetSum, 0);
    }

    private int dfs(TreeNode root, int targetSum, long preSum) {
        if (root == null) {
            return 0;
        }
        preSum += root.val;
        //跟当前节点配对的数量
        int pathCount = preSumCount.getOrDefault(preSum - targetSum, 0);
        //更新count
        preSumCount.put(preSum, preSumCount.getOrDefault(preSum, 0) + 1);
        //递归左右子树
        pathCount += dfs(root.left, targetSum, preSum) + dfs(root.right, targetSum, preSum);
        //一条路径处理完成，需要回溯，把最后一个节点移除
        preSumCount.put(preSum, preSumCount.get(preSum) - 1);
        return pathCount;
    }
}
