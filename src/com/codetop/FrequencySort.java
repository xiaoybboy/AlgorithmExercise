package com.codetop;

import java.util.*;

/**
 * 给定一个字符串 s ，根据字符出现的 频率 对其进行 降序排序 。一个字符出现的 频率 是它出现在字符串中的次数。
 * <p>
 * 返回 已排序的字符串 。如果有多个答案，返回其中任何一个。
 */
public class FrequencySort {

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();

        //统计每个字符的数量
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Character> sortList = new ArrayList<>(map.keySet());
        Collections.sort(sortList, (o1, o2) -> map.get(o2) - map.get(o1));
        //构造排序结果
        StringBuilder builder = new StringBuilder();
        for (int j = 0; j < sortList.size(); j++) {
            int frequency = map.get(sortList.get(j));
            for (int k = 0; k < frequency; k++) {
                builder.append(sortList.get(j));
            }
        }
        return builder.toString();
    }
}
