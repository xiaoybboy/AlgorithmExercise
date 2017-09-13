package com.baseAlgorithm;

import java.util.Scanner;

/**
 * @author XIAO
 * @create 2017-09-08 19:54
 **/
public class Test2 {
    private static int resultCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        backtracking(str);
        System.out.println(resultCount);
    }

    //递归
    private static void backtracking(String curStr) {
        if (curStr.length() == 0) {
            resultCount++;
            return;
        }

        int a = curStr.indexOf("(");
        curStr = curStr.substring(0, a) + curStr.substring(a + 1, curStr.length());

        for (int j = a + 1; j < curStr.length(); j++) {
            if (curStr.charAt(j) == ')') {
                String temp = curStr.substring(0, j) + curStr.substring(j + 1, curStr.length());
                if (Islegal(temp)) {
                    backtracking(temp);
                }
            }
        }
    }

    public static boolean Islegal(String str) {
        boolean flag = true;
        int left = 0;
        int right = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                left++;
            } else if (c == ')') {
                right++;
                if (right > left) {
                    flag = false;
                    break;
                }
            }
        }
        if (left != right) {
            flag = false;
        }
        return flag;
    }
}
