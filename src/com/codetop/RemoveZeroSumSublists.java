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

        Map<Integer, ListNode> map = new HashMap<>();
        int sum = 0;
        //第一次遍历，记录每个和最后一次出现的位置
        for (ListNode cur = dummy; cur != null; cur = cur.next) {
            sum += cur.val;
            map.put(sum, cur);
        }

        int sum2 = 0;
        // 第二遍遍历 若当前节点处sum在下一处出现了则表明两结点之间所有节点和为0 直接删除区间所有节点
        for (ListNode cur = dummy; cur != null; cur = cur.next) {
            sum2 += cur.val;
            cur.next = map.get(sum2).next;
        }
        return dummy.next;
    }
}
