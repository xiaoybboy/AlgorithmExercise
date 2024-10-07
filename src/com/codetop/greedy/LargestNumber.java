package com.codetop.greedy;

import java.util.Arrays;

/**
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * <p>
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 */
public class LargestNumber {

    /**
     * 若拼接字符串 x+y>y+x ，则 x “大于” y 。
     * 反之，若 x+y<y+x ，则 x “小于” y 。
     */
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] ss = new String[nums.length];
        for (int i = 0; i < n; i++) {
            ss[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(ss, (a, b) -> (b + a).compareTo(a + b));
        if (ss[0].equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : ss) sb.append(s);
        return sb.toString();
    }
}
