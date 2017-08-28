package com.company.baidu;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 度度熊收到了一个只有小写字母的字符串S，他对S的子串产生了兴趣，S的子串为S中任意连续的一段。他发现，一些子串只由一种字母构成，
 * 他想知道在S中一共有多少种这样的子串。
 * 例如在串”aaabbaa”中，度度熊想找的子串有”a”,”aa”,”aaa”,”b”,”bb”五种。
 * <p>
 * 输入 输入只有一行，一个字符串，长度不超过100000，只由小写字母组成 样例输入 aaabbaa
 * <p>
 * 输出 输出一行，符合要求的子串种数 样例输出 5
 *
 * @author XIAO
 */
public class SubStringNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        if (str == null || str.length() == 0) {
            return;
        }

        HashSet<String> set = new HashSet<>();// 保存子串結果

        // 遍历，如果当前字符与下一字符相同，则从下一字符开始。如果不同，则end++,子串长度加1
        int begin = 0, end = 1;
        for (int i = 0; i < str.length(); i++) {
            String temp = str.substring(begin, end);
            set.add(temp);
            if (i < str.length() - 1) {
                if (str.charAt(i) == str.charAt(i + 1)) {
                    end++;
                } else {
                    begin = end++;
                }
            }
        }
        System.out.println(set.size());
    }
}
