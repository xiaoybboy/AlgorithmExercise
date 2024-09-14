package com.codetop.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 * <p>
 * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s
 */
public class PartitionLabels {

    public List<Integer> partitionLabels(String s) {
        //1.记录每个字符最后出现的位置下标
        int[] last = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            last[chars[i] - 'a'] = i;
        }
        List<Integer> ans = new ArrayList<>();
        //循环遍历，根据贪心策略划分边界
        int start = 0, end = 0;
        for (int j = 0; j < s.length(); j++) {
            end = Math.max(end, last[s.charAt(j) - 'a']);
            if (j == end) {
                ans.add(end - start + 1);
                start = end + 1;
            }
        }
        return ans;
    }
}
