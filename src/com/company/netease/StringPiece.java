package com.company.netease;

import java.util.Scanner;

/**
 * 一个由小写字母组成的字符串可以看成一些同一字母的最大碎片组成的。例如,"aaabbaaac"是由下面碎片组成的:'aaa','bb','c'。牛牛现在给定
 * 一个字符串,请你帮助计算这个字符串的所有碎片的平均长度是多少。
 * <p>
 * 输入描述:
 * 输入包括一个字符串s,字符串s的长度length(1 ≤ length ≤ 50),s只含小写字母('a'-'z')
 * <p>
 * 输出描述:
 * 输出一个整数,表示所有碎片的平均长度,四舍五入保留两位小数。
 * <p>
 * 如样例所示: s = "aaabbaaac"
 * 所有碎片的平均长度 = (3 + 2 + 3 + 1) / 4 = 2.25
 * <p>
 * 输入例子1:
 * aaabbaaac
 * <p>
 * 输出例子1:
 * 2.25
 * <p>
 * 分析：第一步只需计算字符串的总长度，即为求的的所有碎片的长度总和。
 * 第二步统计一共出现了几次不同的字符串，即上一个与下一个不相同时，count++；
 *
 * @author XIAO
 * @create 2017-09-10 13:09
 **/
public class StringPiece {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = null;
        string = in.nextLine();
        char s = string.charAt(0);
        double count = 1, d;//出现的不同字符串的个数
        for (int i = 0; i < string.length(); i++) {
            if (s != string.charAt(i)) {
                s = string.charAt(i);
                count++;
            }
        }
        d = string.length() / count;
        System.out.println(String.format("%.2f", d));
    }
}
