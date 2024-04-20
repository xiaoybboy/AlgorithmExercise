package com.codetop.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 * <p>
 * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s
 */
public class PartitionLabels {

    //贪心策略
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        int length = s.length();
        //记录每个字母在数组中出现的最后一个位置下标
        for (int i = 0; i < length; i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            //贪心策略，尽可能分成多个片段，并且不重复
            end = Math.max(end, last[s.charAt(i) - 'a']);
            //必须要切分了
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }
}
