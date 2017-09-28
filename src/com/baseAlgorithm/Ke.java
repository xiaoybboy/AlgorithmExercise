package com.baseAlgorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author XIAO
 * @create 2017-09-16 15:44
 **/
public class Ke {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        sc.nextLine();
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = sc.nextLine();
        }

        HashMap<String, String> map = new HashMap<>();
        TreeMap<String, String> res = new TreeMap<>();//保存结果
        for (int j = 0; j < n; j++) {
            String line = strs[j];
            String date = line.split(" ")[0];
            String course = line.split(" ")[1];
            if (!map.containsKey(date)) {
                map.put(date, course);
            } else {
                String temp = map.get(date);
                res.put(date, temp + " " + course);
            }
        }

        if (map.size() == n) {
            System.out.println("YES");
        } else {
            for (Map.Entry<String, String> temp : res.entrySet()) {
                System.out.println(temp.getKey() + " " + temp.getValue());
            }
        }
    }
}
