package com.codetop.slidewindow.variablewindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 某套连招动作记作序列 arr，其中 arr[i] 为第 i 个招式的名字。请返回 arr 中最多可以出连续不重复的多少个招式
 */
public class DismantlingAction {

    public static void main(String[] args) {
        String s = "dbascDdad";
        dismantlingAction(s);
    }

    public static int dismantlingAction(String arr) {
        int ans = 0;
        int start = 0, end = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (end < arr.length()) {
            char ch = arr.charAt(end);
            if (map.containsKey(ch)) {
                //直接寻找上一个重复元素出现位置的下标
                start = Math.max(start, map.get(ch) + 1);
            }
            map.put(ch, end);
            ans = Math.max(ans, end - start + 1);
            end++;
        }
        return ans;
    }
}
