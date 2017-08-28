package com.baseAlgorithm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>由相同字符组成是指组成两个字符串的字母以及各个字母的个数相同，只是排列顺序不同。</p>
 * <p>例如：aaabbc和bcbaaa是由相同字符组成</p>
 *
 * @author XIAO
 * @since 2017/8
 */
public class JudgeStringSame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        if (s1.length() != s2.length()) {
            System.out.println("not same!");
        }

        //转成字符数组
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        //对数组进行排序
        Arrays.sort(c1);
        Arrays.sort(c2);

        if (Arrays.equals(c1, c2)) {
            System.out.println("same");
        } else {
            System.out.println("not same");
        }
    }
}