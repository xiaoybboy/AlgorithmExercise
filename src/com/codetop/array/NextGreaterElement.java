package com.codetop.array;

import com.model.ListNode;

import java.util.*;

public class NextGreaterElement {

    /**
     * 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
     *
     * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
     * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，
     * 那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
     *
     * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
     * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
     * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
     * 给你一个整数数组 nums ，找出 nums 的下一个排列。
     */
    /**
     * 我们仔细观察一下，我们究竟是如何从上一个状态变为下一个状态的呢？我们看
     * <p>
     * [123456]->[123465]
     * [123456]−>[123465]
     * <p>
     * 我们是将比5大的6来进行交换，我们再看下一个例子：
     * <p>
     * [123465]->[123546]
     * [123465]−>[123546]
     * <p>
     * 我们是将比4大的5来进行交换，并将后面的64进行反转，也就是排序。
     * 我们首先要找到两个数字进行交换，并且后面的数字要比前面的数字大，
     * 然后对这个大数后面的数字进行排序，我们可以这样做:
     * <p>
     * 从后往前遍历，找到第一个下降的值nums[i]，和之后刚刚大于这个值的nums[j]交换位置。再对i之后的进行排序。
     * 1、从后向前查找到第一个非降序的数字A。
     * 2、从后向前查找大于A的最小数字B。此时A后面的数字是降序，直接查找大于A的第一个数字即可。
     * 3、A, B互换。
     * 4、A后面的数字现在为降序，重新排序改为升序。
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        Arrays.sort(nums, i + 1, nums.length);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 给你一个正整数 n ，请你找出符合条件的最小整数，其由重新排列 n 中存在的每位数字组成，并且其值大于 n 。如果不存在这样的正整数，则返回 -1
     */
    public int nextGreaterElement(int n) {
        char[] nums = String.valueOf(n).toCharArray();
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap2(nums, i, j);
        } else {
            return -1;
        }
        Arrays.sort(nums, i + 1, nums.length);
        long nextNum = Long.parseLong(String.valueOf(nums));
        if (nextNum == n || nextNum > Integer.MAX_VALUE) {
            return -1;
        }
        return (int) nextNum;
    }

    public void swap2(char[] nums, int i, int j) {
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。
     * <p>
     * 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Map<Integer, Integer> map = helper(nums2);
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }
        return result;
    }

    /**
     * 单调栈，查找num2中，每个比前面的元素更大的索引
     */
    private Map<Integer, Integer> helper(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            // 栈不为空且当前元素大于栈顶元素
            // 说明当前元素是栈顶元素的下一个更大元素
            // while循环表示当前元素是栈中所有已存元素的下一个更大元素
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                map.put(stack.pop(), nums[i]);
            }
            // 将当前考察元素入栈，看后面是否有其下一个更大元素
            stack.push(nums[i]);
        }
        // 栈中剩余的元素是没有下一个更大元素的元素
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }
        return map;
    }

    /**
     * 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。
     * <p>
     * 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。
     * 如果不存在，则输出 -1 。
     */
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        // 先将结果数组中的值赋值为-1
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n * 2; i++) {
            // 如果栈不为空，且栈中元素小于当前考察的元素
            // 则当前考察的元素是栈中元素的下一个更大元素
            // i % n 对数组长度取余，模拟循环数组
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                res[stack.pop()] = nums[i % n];
            }
            // 当前元素的索引取余后入栈，看后面是否有其下一个更大元素
            stack.push(i % n);
        }
        return res;
    }

    /**
     * 给定一个长度为 n 的链表 head
     * <p>
     * 对于列表中的每个节点，查找下一个 更大节点 的值。也就是说，对于每个节点，找到它旁边的第一个节点的值，这个节点的值 严格大于 它的值。
     * <p>
     * 返回一个整数数组 answer ，其中 answer[i] 是第 i 个节点( 从1开始 )的下一个更大的节点的值。如果第 i 个节点没有下一个更大的节点，
     * 设置 answer[i] = 0 。
     */
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> ans = new ArrayList<>();
        Deque<int[]> stack = new ArrayDeque<>();

        ListNode cur = head;
        int idx = -1;
        while (cur != null) {
            ++idx;
            ans.add(0);
            while (!stack.isEmpty() && stack.peek()[0] < cur.val) {
                ans.set(stack.pop()[1], cur.val);
            }
            stack.push(new int[]{cur.val, idx});
            cur = cur.next;
        }

        int size = ans.size();
        int[] arr = new int[size];
        for (int i = 0; i < size; ++i) {
            arr[i] = ans.get(i);
        }
        return arr;
    }
}
