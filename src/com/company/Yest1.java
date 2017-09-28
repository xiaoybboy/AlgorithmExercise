package com.company;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author XIAO
 * @create 2017-09-26 19:51
 **/
public class Yest1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // ArrayList<Integer> queA = new ArrayList<>();
        // ArrayList<Integer> queB = new ArrayList<>();
        int[] queA = new int[n];
        int[] queB = new int[n];
        for (int i = 0; i < n; i++) {
            queA[i] = sc.nextInt();
        }
        for (int j = 0; j < n; j++) {
            queB[j] = sc.nextInt();
        }

        Arrays.sort(queA);
        Arrays.sort(queB);

        int index = 0;
        int templ = n - 1;
        boolean flag = true;
        int k = n - 1;
        for (; k >= 0; k--) {
            int temp = queA[k];
            for (int l = templ; l >= 0; l--) {//找到比temp小的第一个数
                if (temp > queB[l]) {
                    index++;
                    templ = l - 1;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }

        int indexping = 0;
        int templ2 = n - 1;
        for (int m = k; m >= 0; m--) {
            int temp2 = queA[m];
            for (int p = templ2; p >= 0; p--) {//找到比temp2相等
                if (temp2 == queB[p]) {
                    indexping++;
                    templ2 = p - 1;
                }
            }
        }

        int max = index * 100 - (n - index - indexping) * 100;
        System.out.println(max);
    }
}
