package com.company.ctrip;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 * 给定一些字符串，请写一个算法，从中搜索出包含您输入的字符序列的那些字符串，按匹配度的高低排序输出。没有任何一个字符串匹配上，输出-1。
 * 字符串源source 如下： "AB", "ABC", "ACB", "ABCD", "ADBCF", "ABDCF", "ABDC",
 * "ABDFCG", "ABDFGC", "ABDEFG", "GABCEFG"
 * <p>
 * 若输入查找的有序字符序列为"ABC"，则运算结果如下（请注意结果的排序规则）。
 * <p>
 * ABC （匹配 ABC）(完全匹配上，匹配度最大)
 * <p>
 * ABCD （匹配ABC.）
 * <p>
 * ABDC （匹配 AB.C）
 * <p>
 * ABDCF （匹配 AB.C.）
 * <p>
 * ABDFCG （匹配 AB..C.）
 * <p>
 * ABDFGC （匹配 AB...C）
 * <p>
 * ADBCF （匹配 A.BC.）
 * <p>
 * GABCEFG（匹配 .ABC...）
 * <p>
 * <p>
 * 输入 您需要查找的字符串 样例输入 ABC 输出 按匹配度高低排序输出查找到的结果。没有任何一个字符串匹配上，输出-1。
 * <p>
 * 样例输出
 * <p>
 * ABC ABCD ABDC ABDCF ABDFCG ABDFGC ADBCF GABCEFG
 *
 * @author XIAO
 */
public class StringMatching {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = {"AB", "ABC", "ACB", "ABCD", "ADBCF", "ABDCF", "ABDC", "ABDFCG", "ABDFGC", "ABDEFG",
                "GABCEFG"};

        while (sc.hasNext()) {
            String str = sc.next();
            TreeMap<Integer, String> map = new TreeMap<>();
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].length() < str.length()) {
                    continue;
                } else {
                    char[] chars = strs[i].toCharArray();
                    char[] dest = str.toCharArray();
                    int[] result = new int[7];

                    for (int j = 0; j < result.length; j++) {
                        result[j] = 1;
                    }
                    int m = 0, n = 0;
                    while (m < chars.length && n < dest.length) {
                        if (chars[m] == dest[n]) {
                            m++;
                            n++;
                        } else {
                            result[m] = 0;
                            m++;
                        }
                    }
                    while (m < chars.length) {
                        result[m] = 0;
                        m++;
                    }
                    if (n < dest.length) {
                        continue;
                    } else {
                        int sum = 0;
                        for (int k = 0; k < result.length; k++) {
                            sum = (int) (sum + result[k] * Math.pow(2, result.length - 1 - k));
                        }
                        if (map.containsKey(sum)) {
                            map.put(sum, map.get(sum) + "\n" + strs[i]);
                        } else {
                            map.put(sum, strs[i]);
                        }

                    }

                }
            }
            if (map.size() == 0) {
                System.out.println(-1);
            } else {
                Set<Integer> set = map.descendingKeySet();
                for (int i : set) {
                    System.out.println(map.get(i));
                }
            }
        }
    }

}
