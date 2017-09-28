package com.baseAlgorithm;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author XIAO
 * @create 2017-09-17 19:48
 **/
public class suhu2 {
    private static int minRes = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        getres(0, 0, list);
        System.out.println(minRes);
    }

    public static void getres(int start, int cursum, ArrayList<Integer> templist) {
        if (start > templist.size() / 2) {
            if (cursum < minRes)
                minRes = cursum;
            return;
        }
        for (int j = start; j <= templist.size() / 2; j++) {
            int temp1 = templist.get(j);
            int temp2 = templist.get(templist.size() - j - 1);
            if (temp1 == temp2) {
                cursum += temp1 * 2;
                continue;
            } else {
                templist.set(j, temp2);
                getres(start + 1, cursum + 2 * temp2, templist);
                templist.remove(j);

                templist.set(templist.size() - j - 1, temp1);
                getres(start + 1, cursum + 2 * temp1, templist);
                templist.remove(j);
            }
        }
    }
}