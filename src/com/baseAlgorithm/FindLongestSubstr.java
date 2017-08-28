package com.baseAlgorithm;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * <p>
 * 给定一个字符串，寻找这个字符串的最长不重复子串(子串里面没有重复字母)。例如：对于字符串“abcabcbb”，它的最长不重复子串是“abc”，
 * 长度为3；而对于字符串“bbbbb”，它的最长不重复子串是“b”，长度为1。
 *</p>
 * @author XIAO
 */
public class FindLongestSubstr {

	/* 请完成下面这个函数，实现题目要求的功能 */
    /* 当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^ */

    /****************************** 开始写代码 ******************************/
    static String calDuplicateString(String str) {
        String maxLengthStr = "";
        int maxLength = 0;
        // 遍历所有的字符串子串
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                String temp = str.substring(i, j);
                Set<Character> characters = new HashSet<>();// 看子串里面是否有重复字符
                for (int k = 0; k < temp.length(); k++) {
                    characters.add(temp.charAt(k));
                }
                if (characters.size() == temp.length()) {
                    if (characters.size() > maxLength) {
                        maxLength = characters.size();
                        maxLengthStr = temp;
                    }
                }
            }
        }
        return maxLengthStr;
    }

    /****************************** 结束写代码 ******************************/

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res;

        String _str;
        try {
            _str = in.nextLine();
        } catch (Exception e) {
            _str = null;
        }

        res = calDuplicateString(_str);
        System.out.println(res);
    }
}
