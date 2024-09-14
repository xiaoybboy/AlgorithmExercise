package com.codetop.tree;

//LCR 152. 验证二叉搜索树的后序遍历序列
public class VerifyTreeOrder {

    public static void main(String[] args) {
        int[] postorder = {4, 6, 5, 9, 8};
        verifyTreeOrder(postorder);
    }

    public static boolean verifyTreeOrder(int[] postorder) {
        return verify(postorder, 0, postorder.length - 1);
    }

    private static boolean verify(int[] postOrder, int start, int end) {
        if (start >= end) {
            return true;
        }
        //寻找左子树的终止位置<最后一个节点即根节点
        int leftEnd = start;
        while (postOrder[leftEnd] < postOrder[end]) {
            leftEnd++;
        }
        int rightEnd = leftEnd;
        while (postOrder[rightEnd] > postOrder[end]) {
            rightEnd++;
        }
        return rightEnd == end && verify(postOrder, start, leftEnd - 1) && verify(postOrder, leftEnd, end - 1);
    }
}
