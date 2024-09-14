package com.codetop.doublePoint;

import com.model.ListNode;

public class DeleteDuplicates {

    //给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int val = cur.next.val;
                while (cur.next != null && cur.next.val == val) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    //给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
    public int removeDuplicates(int[] nums) {
        int start = 0, end = 1;
        int count = 1;
        while (end < nums.length) {
            if (nums[end] != nums[start]) {
                start++;
                nums[start] = nums[end];
                count = 1;
            } else {
                count++;
                if (count <= 2) {
                    start++;
                    nums[start] = nums[end];
                }
            }
            end++;
        }
        return start + 1;
    }
}
