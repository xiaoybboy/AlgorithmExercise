package com.codetop.backtrack;

import java.util.HashSet;
import java.util.List;

/**
 * 给定一个字符串数组 arr，字符串 s 是将 arr 的含有 不同字母 的 子序列 字符串 连接 所得的字符串。
 * 请返回所有可行解 s 中最长长度。
 * 子序列 是一种可以从另一个数组派生而来的数组，通过删除某些元素或不删除元素而不改变其余元素的顺序。
 */
public class MaxLength {

    int ans = 0;
    StringBuilder builder = new StringBuilder();

    public int maxLength(List<String> arr) {
        backTrack(arr, 0);
        return ans;
    }

    private void backTrack(List<String> arr, int start) {
        if (!isValid(builder.toString())) return;
        ans = Math.max(ans, builder.length());
        for (int i = start; i < arr.size(); i++) {
            String tmp = arr.get(i);
            builder.append(tmp); // 做选择
            backTrack(arr, i + 1);
            builder.delete(builder.length() - tmp.length(), builder.length()); // 撤销选择
        }
    }

    private boolean isValid(String s) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) return false;
            set.add(s.charAt(i));
        }
        return true;
    }
}
