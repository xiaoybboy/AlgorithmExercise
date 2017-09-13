package com.baseAlgorithm;

import java.util.Scanner;

/**
 * @author XIAO
 * @create 2017-09-13 19:02
 **/
public class HuaWei1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();

        int count = 0;//几位数
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            if (c >= '1' && c <= '9') {
                count++;
            }
        }
        System.out.println(count);

        //加空格输出
        StringBuilder builder = new StringBuilder();
        for (int j = 0; j < num.length(); j++) {
            char c = num.charAt(j);
            if (j == 0) {
                if (c == '-') {
                    builder.append(c);
                } else {
                    builder.append(c + " ");
                }
            } else if (j != num.length() - 1) {
                builder.append(c + " ");
            } else {
                builder.append(c);
            }
        }
        System.out.println(builder.toString());

        //反向输出
        StringBuilder builder2 = new StringBuilder();
        String result = "";
        for (int k = num.length() - 1; k > 0; k--) {
            builder2.append(num.charAt(k));
        }
        char temp = num.charAt(0);
        if (temp == '-') {
            result = "-" + builder2.toString();
        } else {
            result = builder2.append(temp).toString();
        }

        System.out.println(Integer.parseInt(result));
    }
}
