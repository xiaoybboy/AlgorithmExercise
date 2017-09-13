package com.baseAlgorithm;

import java.util.Scanner;

/**
 * @author XIAO
 * @create 2017-09-08 19:44
 **/
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    for (int l = 1; l <= n; l++) {
                        if (Math.pow(i, j) == Math.pow(k, l)) {
                            result++;
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }
}
