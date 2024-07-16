package com.codetop.doublePoint;

import java.util.List;

/**
 * 给你一个字符串 s 和一个字符串数组 dictionary ，找出并返回 dictionary 中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
 * <p>
 * 如果答案不止一个，返回长度最长且字母序最小的字符串。如果答案不存在，则返回空字符串
 */
public class FindLongestWord {

    public String findLongestWord(String s, List<String> dictionary) {
        String result = "";
        for (String word : dictionary) {
            int i = 0, j = 0;
            while (i < word.length() && j < s.length()) {
                //用词典中的单词，去s中一一匹配字符
                if (word.charAt(i) == s.charAt(j)) {
                    i++;
                }
                j++;
            }
            if (i == word.length()) {
                if (word.length() > result.length() || (word.length() == result.length() && word.compareTo(result) < 0)) {
                    result = word;
                }
            }
        }
        return result;
    }
}
