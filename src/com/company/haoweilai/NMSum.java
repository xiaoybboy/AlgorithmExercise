package com.company.haoweilai;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 输入两个整数 n 和 m，从数列1，2，3.......n 中随意取几个数,使其和等于 m ,要求将其中所有的可能组合列出来
 * <p>
 * 输入描述:
 * 每个测试输入包含2个整数,n和m
 * <p>
 * 输出描述:
 * 按每个组合的字典序排列输出,每行输出一种组合
 * <p>
 * 输入例子1:
 * 5 5
 * <p>
 * 输出例子1:
 * 1 4 2 3 5
 *
 * @author XIAO
 * @create 2017-09-07 10:23
 **/
public class NMSum {
    private static List<List<Integer>> result = new ArrayList<>();
    private static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        GetSum(1, m, n);
        for (List<Integer> l : result) {
            int i = 0;
            for (; i < l.size() - 1; i++) {
                System.out.print(l.get(i) + " ");
            }
            System.out.println(l.get(i));
        }
    }

    //回溯
    public static void GetSum(int start, int target, int n) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
        } else {
            for (int i = start; i <= target && i <= n; i++) {
                list.add(i);
                GetSum(i + 1, target - i, n);
                list.remove(list.size() - 1);
            }
        }
    }
}