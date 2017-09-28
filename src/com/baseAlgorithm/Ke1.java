package com.baseAlgorithm;

import java.util.Scanner;

/**
 * @author XIAO
 * @create 2017-09-16 16:12
 **/
public class Ke1 {
    public static int res = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        getRes(s);
        System.out.println(res);
    }

    //不允许重复放入
    private static void backtracking(String cur) {

        for (int i = 0; i < cur.length(); i++) {
            if (cur.charAt(i) == 'R' && cur.charAt(i + 1) == 'L') {
                String newstr1 = cur.substring(0, i) + cur.substring(i + 1, cur.length());
                backtracking(newstr1);
            }
        }

        for (int j = 0; j < cur.length(); j++) {
            if (cur.charAt(j) == 'R' && cur.charAt(j + 1) == 'L') {
                String newstr2 = cur.substring(0, j + 1) + cur.substring(j + 2, cur.length());
                backtracking(newstr2);
            }
        }

    }

    public static void getRes(String s) {
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R' && s.charAt(i + 1) == 'L') {
                flag = true;
                String newstr1 = s.substring(0, i) + s.substring(i + 1, s.length());
                getRes(newstr1);

                String old = s;

                String newstr2 = old.substring(0, i + 1) + old.substring(i + 2, s.length());
                getRes(newstr2);

                break;
            }
        }
        if (flag == false) {
            res = Math.min(s.length(), res);
            return;
        }
    }
}
