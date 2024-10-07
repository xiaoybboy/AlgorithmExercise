package com.codetop;

import com.model.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个链表的头节点 head，请你编写代码，反复删去链表中由 总和 值为 0 的连续节点组成的序列，直到不存在这样的序列为止。
 * <p>
 * 删除完毕后，请你返回最终结果链表的头节点。
 */
public class RemoveZeroSumSublists {

    public static ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0, head);

        //1.记录每个前缀和最后出现的位置
        int sum = 0;
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode cur = dummy;
        while (cur != null) {
            sum += cur.val;
            map.put(sum, cur);
            cur = cur.next;
        }
        //2.删除中间和为0的节点
        int sum2 = 0;
        ListNode cur2 = dummy;
        while (cur2 != null) {
            sum2 += cur2.val;
            if (map.containsKey(sum2)) {
                cur2.next = map.get(sum2).next;
            }
            cur2 = cur2.next;
        }
        return dummy.next;
    }
}
