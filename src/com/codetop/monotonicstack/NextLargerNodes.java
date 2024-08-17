package com.codetop.monotonicstack;

import com.model.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个长度为 n 的链表 head
 * <p>
 * * 对于列表中的每个节点，查找下一个 更大节点 的值。也就是说，对于每个节点，找到它旁边的第一个节点的值，这个节点的值 严格大于 它的值。
 * * 返回一个整数数组 answer ，其中 answer[i] 是第 i 个节点( 从1开始 )的下一个更大的节点的值。如果第 i 个节点没有下一个更大的节点，设置 answer[i] = 0 。
 */
public class NextLargerNodes {

    public int[] nextLargerNodes(ListNode head) {
        int n = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            n++;
        }
        int[] ans = new int[n];
        Deque<Node> deque = new ArrayDeque<>();
        node = head;
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && node.val > deque.peek().val) {
                Node curNode = deque.pop();
                ans[curNode.index] = node.val;
            }
            deque.push(new Node(i, node.val));
            node = node.next;
        }
        return ans;
    }

    public class Node {
        private int index;
        private int val;

        public Node(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }
}
