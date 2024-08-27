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
        backTracking(s, 0);
        return lists;
    }

    private void backTracking(String s, int start) {
        //找到一种切割方法
        if (start == s.length()) {
            lists.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            //从i处切割，看能不能构成回文串
            if (isPalindrome(s, start, i)) {
                tempList.add(s.substring(start, i + 1));
                backTracking(s, i + 1);
                tempList.removeLast();
            }
        }
    }

    //判断是否是回文串
    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end && s.charAt(start) == s.charAt(end)) {
            start++;
            end--;
        }
        return start > end;
    }
}
