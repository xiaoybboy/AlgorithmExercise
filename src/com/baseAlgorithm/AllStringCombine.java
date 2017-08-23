package com.baseAlgorithm;

import java.util.Scanner;

/**
 * 问题描述：假设字符串中所有的字符都不重复，输出字符串中的所有组合！
 * 例如：输入字符串"abc"，输出  a,b,c,ab,ac,bc,abc  7种可能，
 *
 * @author XIAO
 */
public class AllStringCombine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        char[] c = str.toCharArray();
        StringBuffer buffer = new StringBuffer();
        int length = c.length;
        for (int i = 0; i < length; i++) {
            CombineRecursiveImpl(c, 0, i, buffer);
        }

    }

    //回朔法
    private static void CombineRecursiveImpl(char[] c, int begin, int len,
                                             StringBuffer sb) {
        if (len == 0) {
            System.out.println(sb + " ");
            return;
        }
        if (begin == c.length) {
            return;
        }
        sb.append(c[begin]);
        CombineRecursiveImpl(c, begin + 1, len - 1, sb);
        sb.deleteCharAt(sb.length() - 1);
        CombineRecursiveImpl(c, begin + 1, len, sb);
    }
}
