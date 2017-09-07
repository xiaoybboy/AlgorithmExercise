package com.company.haoweilai;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 输入两个字符串，从第一字符串中删除第二个字符串中所有的字符。例如，输入”They are students.”和”aeiou”，则删除之后的第一个
 * 字符串变成”Thy r stdnts.”
 * 输入描述:
 * 每个测试输入包含2个字符串
 * <p>
 * 输出描述:
 * 输出删除后的字符串
 * <p>
 * 输入例子1:
 * They are students. aeiou
 * <p>
 * 输出例子1:
 * Thy r stdnts.
 *
 * @author XIAO
 * @create 2017-09-07 10:13
 **/
public class DeletePublicChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        HashSet<Character> s2Set = new HashSet<>();
        for (int i = 0; i < s2.length(); i++) {
            s2Set.add(s2.charAt(i));
        }

        StringBuilder builder = new StringBuilder();
        for (int j = 0; j < s1.length(); j++) {
            char temp = s1.charAt(j);
            if (!s2Set.contains(temp)) {
                builder.append(temp);
            }
        }
        System.out.println(builder.toString());
    }
}
