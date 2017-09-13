package com.baseAlgorithm;

import java.util.Scanner;

/**
 * @author XIAO
 * @create 2017-09-13 19:24
 **/
public class Huawei2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String s3 = sc.nextLine();
        String s4 = sc.nextLine();

        if (compare(s2, s3) == 2 || compare(s4, s1) == 2) {
            System.out.println("No Overlap IP");
        } else {
            System.out.println("Overlap IP");
        }
    }

    public static int compare(String s1, String s2) {
        int result = 0;
        String[] s1arr = s1.split("\\.");
        String[] s2arr = s2.split("\\.");

        for (int i = 0; i < 4; i++) {
            int s1temp = Integer.parseInt(s1arr[i]);
            int s2temp = Integer.parseInt(s2arr[i]);
            if (s1temp > s2temp) {
                result = 1;
                break;
            } else if (s1temp < s2temp) {
                result = 2;
                break;
            } else {
                continue;
            }

        }
        return result;
    }
}
