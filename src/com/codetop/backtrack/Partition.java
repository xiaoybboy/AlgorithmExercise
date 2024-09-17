package com.codetop.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文串。返回 s 所有可能的分割方案。
 */
public class Partition {

    List<List<String>> lists = new ArrayList<>();
    LinkedList<String> tempList = new LinkedList<>();

    public List<List<String>> partition(String s) {
        backTrack(s, 0);
        return lists;
    }

    private void backTrack(String s, int start) {
        if (start == s.length()) {
            lists.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            //如果构不成回文串
            if (!isPalindrome(s, start, i)) {
                continue;
            }
            tempList.add(s.substring(start, i + 1));
            backTrack(s, i + 1);
            tempList.removeLast();
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end && s.charAt(start) == s.charAt(end)) {
            start++;
            end--;
        }
        return start > end;
    }
}
