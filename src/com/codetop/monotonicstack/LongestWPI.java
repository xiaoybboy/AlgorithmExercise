package com.codetop.monotonicstack;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。
 * <p>
 * 我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。
 * 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。
 * 请你返回「表现良好时间段」的最大长度。
 */
public class LongestWPI {

    public int longestWPI(int[] hours) {
        int s = 0;//s表示从0到当前位置前缀和
        int ans = 0;
        Map<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < hours.length; ++i) {
            //求前缀和
            s += hours[i] > 8 ? 1 : -1;
            if (s > 0) {
                //S>0的时候，说明是满足表现良好的条件的
                ans = i + 1;
            } else if (pos.containsKey(s - 1)) {
                //为什么找s-1.因为s-1是j位置的前缀和。s-(s-1) = 1>0,说明从j到i中间这段区域的和=1>0,是满足条件的
                ans = Math.max(ans, i - pos.get(s - 1));
            }
            //map记录第一次出现某个和的位置
            pos.putIfAbsent(s, i);
        }
        return ans;
    }
}
