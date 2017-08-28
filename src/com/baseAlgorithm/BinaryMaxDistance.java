package com.baseAlgorithm;

import com.model.TreeNode;

/**
 * <p>
 * 我们姑且定义"距离"为两节点之间边的个数。
 * 求一棵二叉树中相距最远的两个节点之间的距离
 * </p>
 * 计算一个二叉树的最大距离有两个情况:
 * <p>
 * 情况A: 路径经过左子树的最深节点，通过根节点，再到右子树的最深节点。
 * 情况B: 路径不穿过根节点，而是左子树或右子树的最大距离路径，取其大者。
 * 只需要计算这两个情况的路径距离，并取其大者，就是该二叉树的最大距离。
 * </p>
 *
 * @author XIAO
 */
public class BinaryMaxDistance {
    static int MaxLen = 0;

    public void FindMaxLen(Node pRoot) {
        if (pRoot == null) {
            return;
        }
        if (pRoot.pLeft == null) {
            pRoot.MaxLeft = 0;
        }
        if (pRoot.pRight == null) {
            pRoot.MaxRight = 0;
        }
        if (pRoot.pLeft != null) {
            FindMaxLen(pRoot.pLeft);
        }
        if (pRoot.pRight != null) {
            FindMaxLen(pRoot.pRight);
        }
        if (pRoot.pLeft != null) {
            int nTempMax = 0;
            nTempMax = pRoot.pLeft.MaxLeft > pRoot.pLeft.MaxRight ? pRoot.pLeft.MaxLeft : pRoot.pLeft.MaxRight;
            pRoot.MaxLeft = nTempMax + 1;
        }
        if (pRoot.pRight != null) {
            int nTempMax = 0;
            nTempMax = pRoot.pRight.MaxLeft > pRoot.pRight.MaxRight ? pRoot.pRight.MaxLeft : pRoot.pRight.MaxRight;
            pRoot.MaxRight = nTempMax + 1;
        }
        if (pRoot.MaxLeft + pRoot.MaxRight > MaxLen) {
            MaxLen = pRoot.MaxLeft + pRoot.MaxRight;
        }
    }

    class Node {
        Node pLeft;
        Node pRight;
        int MaxLeft;
        int MaxRight;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }
}
