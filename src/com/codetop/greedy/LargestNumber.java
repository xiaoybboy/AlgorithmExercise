package com.codetop.greedy;

import java.util.PriorityQueue;

/**
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * <p>
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 */
public class LargestNumber {

    /**
     * 贪心策略：
     * <p>
     * 若拼接字符串 x+y>y+x ，则 x “大于” y 。
     * 反之，若 x+y<y+x ，则 x “小于” y 。
     * <p>
     *
     * @param nums
     * @return
     */
    public String largestNumber(int[] nums) {
        PriorityQueue<String> heap = new PriorityQueue<>((x, y) -> (y + x).compareTo(x + y));
        for (int x : nums) {
            heap.offer(String.valueOf(x));
        }
        String res = "";
        while (heap.size() > 0) {
            res += heap.poll();
        }
        if (res.charAt(0) == '0') {
            return "0";
        }
        return res;
    }
}
