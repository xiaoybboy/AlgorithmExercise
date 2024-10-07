package com.codetop.tree;

import com.model.TreeNode;

import java.util.*;

/**
 * 二叉树相关操作
 *
 * @author XIAO
 * @since 2017-09-07 19:43
 **/
public class BinaryTree {
    /**
     * 遍历二叉树
     *
     * @param root
     */
    static void scanNodes(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val); //先序遍历
        scanNodes(root.left);
        //System.out.println(root.val); 中序遍历
        scanNodes(root.right);
        //System.out.println(root.val); 后序遍历
    }

    /**
     * 获取二叉树节点的个数
     *
     * @param root
     * @return
     */
    private static int numOfTreeNode(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = numOfTreeNode(root.left);
        int right = numOfTreeNode(root.right);
        return left + right + 1;
    }

    /**
     * 二叉树叶子节点的个数
     *
     * @param root
     * @return
     */
    private static int numsOfNoChildNode(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return numsOfNoChildNode(root.left) + numsOfNoChildNode(root.right);
    }

    /**
     * 二叉树第k层节点的个数
     *
     * @param root
     * @param k
     * @return
     */
    private static int numsOfkLevelTreeNode(TreeNode root, int k) {
        if (root == null || k < 1) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        int numsLeft = numsOfkLevelTreeNode(root.left, k - 1);
        int numsRight = numsOfkLevelTreeNode(root.right, k - 1);
        return numsLeft + numsRight;
    }

    /**
     * 判断是否是平衡二叉树
     *
     * @param node
     * @return
     */
    private static boolean isBalanced(TreeNode node) {
        return maxDeath2(node) != -1;
    }

    private static int maxDeath2(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = maxDeath2(node.left);
        int right = maxDeath2(node.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }

    /**
     * 两个二叉树是否完全相同
     *
     * @param t1
     * @param t2
     * @return
     */
    boolean isSameTreeNode(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        } else if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.val != t2.val) {
            return false;
        }
        boolean left = isSameTreeNode(t1.left, t2.left);
        boolean right = isSameTreeNode(t1.right, t2.right);
        return left && right;
    }

    /**
     * 两个二叉树是否互为镜像
     * <p>
     * 互为镜像的条件：
     * 1.它们的两个根结点具有相同的值
     * 2.每个树的右子树都与另一个树的左子树镜像对称
     *
     * @param t1
     * @param t2
     * @return
     */
    boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return t1.val == t2.val && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }

    /**
     * 翻转二叉树or镜像二叉树
     *
     * @param root
     * @return
     */
    TreeNode mirrorTreeNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = mirrorTreeNode(root.left);
        TreeNode right = mirrorTreeNode(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    /**
     * 输入一个二叉树和一个整数，打印出二叉树中节点值的和等于输入整数所有的路径
     *
     * @param root
     * @param i
     */
    void findPath1(TreeNode root, int i) {
        if (root == null) {
            return;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int currentSum = 0;
        findPath2(root, i, stack, currentSum);
    }

    void findPath2(TreeNode root, int i, Stack<Integer> stack, int currentSum) {
        currentSum += root.val;
        stack.push(root.val);
        if (root.left == null && root.right == null) {
            if (currentSum == i) {
                for (int path : stack) {
                    System.out.println(path);
                }

            }
        }
        if (root.left != null) {
            findPath2(root.left, i, stack, currentSum);
        }
        if (root.right != null) {
            findPath2(root.right, i, stack, currentSum);
        }
        stack.pop();
    }

    /**
     * 层次遍历
     *
     * @param root
     * @return
     */
    ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(level);
        }
        return result;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<List<Integer>> deque = new ArrayDeque<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            deque.push(level);
        }
        while (!deque.isEmpty()) {
            result.add(deque.pop());
        }
        return result;
    }

    /**
     * 锯齿型遍历
     * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);

        boolean order = true;
        while (!deque.isEmpty()) {
            int size = deque.size();
            Deque<Integer> tempList = new ArrayDeque<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = deque.poll();
                if (order) {
                    //正向
                    tempList.offer(treeNode.val);
                } else {
                    //反向
                    tempList.offerFirst(treeNode.val);
                }
                if (treeNode.left != null) {
                    deque.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    deque.offer(treeNode.right);
                }
            }
            ans.add(new ArrayList<>(tempList));
            order = !order;
        }
        return ans;
    }

    public int lastVal = Integer.MAX_VALUE;
    public boolean firstNode = true;

    /**
     * 获取二叉树的深度
     *
     * @param root
     * @return
     */
    static int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        return Math.max(left + 1, right + 1);
    }

    /**
     * 获取二叉树最大宽度
     *
     * @param root
     * @return
     */
    public static int getMaxWidth(TreeNode root) {
        if (root == null)
            return 0;

        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        int maxWitdth = 1; // 最大宽度
        queue.add(root); // 入队

        while (true) {
            int len = queue.size(); // 当前层的节点个数
            if (len == 0)
                break;
            while (len > 0) {// 如果当前层，还有节点
                TreeNode t = queue.poll();
                len--;
                if (t.left != null)
                    queue.add(t.left); // 下一层节点入队
                if (t.right != null)
                    queue.add(t.right);// 下一层节点入队
            }
            maxWitdth = Math.max(maxWitdth, queue.size());
        }
        return maxWitdth;
    }
}
