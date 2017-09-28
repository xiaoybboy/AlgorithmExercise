package com.company.souhu;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author XIAO
 * @create 2017-09-23 14:02
 **/
public class SimplifyPath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String res = simplifyPath(s);
        System.out.println(res);
    }

    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        String[] str = path.split("/");

        for (int i = 0; i < str.length; i++) {
            if (str[i].equals(".") || str[i].equals("/")) {

            } else if (str[i].equals("..")) {
                stack.pop();
            } else {
                stack.push(str[i]);
            }
        }
        if (stack.isEmpty()) return "/";

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            if (stack.peek().equals("")) stack.pop();
            else sb.insert(0, "/" + stack.pop());
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
