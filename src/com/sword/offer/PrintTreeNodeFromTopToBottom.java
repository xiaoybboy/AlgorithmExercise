package com.sword.offer;

import com.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * <p>
 * 思路：这道题就是一个模板题，对队列的使用。因为要满足先进先出的特性。
 * <p>
 * 初始化：一个队列queue<TreeNode*> q， 将root节点入队列q
 * 如果队列不空，做如下操作：
 * 弹出队列头，保存为node，将node的左右非空孩子加入队列
 * 做2,3步骤，知道队列为空
 */
public class PrintTreeNodeFromTopToBottom {

    /**
     * 按照层级，从上到下打印二叉树
     *
     * @param root
     * @return
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        //queue用来保存当前遍历到了哪个节点，一次性把一个节点的左右子都入队
        Queue<TreeNode> queue = new LinkedList<>();
        //list用来保存输出的节点
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {//注意：空树返回一个默认构造的空LinkedList，而不是一个空指针null
            return list;
        }
        TreeNode current = root;
        queue.offer(current);
        //只要队列中还有节点就说明还没遍历完，继续。
        //每次从队列出队，然后将这个节点左右子入队列（FIFO，故能完成广度/层级遍历），再将这个节点记录在list中即可。
        while (!queue.isEmpty()) {
            current = queue.poll();
            list.add(current.val);
            if (current.left != null) {//有左子则入队
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
        return list;
    }
}
